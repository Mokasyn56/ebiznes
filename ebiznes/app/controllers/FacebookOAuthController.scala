package controllers

import javax.inject._
import models.User
import play.api.libs.json.Json
import play.api.mvc._
import DAOs.UserRepository
import services.{AuthenticationService, FacebookAuthService}

import scala.concurrent.{ExecutionContext, Future}

class FacebookOAuthController @Inject()(userRepository: UserRepository,
                                      facebookAuthService: FacebookAuthService,
                                      authenticationService: AuthenticationService,
                                      orderController: OrderController,
                                      cc: MessagesControllerComponents)
                                     (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

    var UserEmail: String = "";

    def setUserEmail(email: String) = {
        this.UserEmail = email;
    }

    def onAuthResponse: Action[AnyContent] = Action.async { implicit request =>
        if (!facebookAuthService.isRedirectAuthStringValid(request.queryString)) {
            Future {
                Unauthorized("Bad Redirect Authorization link")
            }
        } else {
            facebookAuthService.getTokenFromAuthString(request.queryString).flatMap { response =>
                if (!facebookAuthService.validateTokenResponse(response)) {
                    Future {
                        Unauthorized("Bad credentials")
                    }
                } else {
                    val facebookAuthResponse = facebookAuthService.getTokenResponse(response)
                    facebookAuthService.getUser(facebookAuthResponse).flatMap { userInfoResponse =>
                        println(userInfoResponse)
                        authenticationService.addFacebookUser(userInfoResponse.email, facebookAuthResponse.accessToken).map{user =>
                            Future{
                                user
                        }
                            setUserEmail(userInfoResponse.email)
                            Redirect("http://localhost:4200/shop")
                        }
                    }
                }
            }
        }
    }

    def onFacebookLogin: Action[AnyContent] = Action { implicit request =>
        Redirect(facebookAuthService.FACEBOOK_AUTH_URL, facebookAuthService.buildParamsToAuthUrl)
    }

    def logoutUser: Action[AnyContent] = Action.async { implicit request =>
        println("logging out user")
        val userEmail = UserEmail
        userRepository.listUserByEmail(userEmail).map { userOption =>
            if (userOption.isEmpty) {
                NoContent
            } else {
                val user = userOption.get
                val userToUpdate = User(user.id, user.email, None, None)
                userRepository.updateUser(userToUpdate)
                Ok(Json.toJson("user logged out"))
                Redirect("http://localhost:4200/logout")
            }
        }
    }

    def addOrder(): Action[AnyContent] = {
        return orderController.addOrder(UserEmail)
    }

}