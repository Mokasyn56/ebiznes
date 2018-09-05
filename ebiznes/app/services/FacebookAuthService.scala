package services

import javax.inject.Inject
import models.facebook.{FacebookAuthResponse, FacebookUser}
import play.api.libs.ws._

import scala.concurrent.{ExecutionContext, Future}

class FacebookAuthService @Inject()(ws: WSClient,
                                  oAuthConfigurationService: OAuthConfigurationService)
                                 (implicit ec: ExecutionContext) {
    val FACEBOOK_AUTH_URL: String = "https://www.facebook.com/dialog/oauth"
    private val AUTH_URL_SCOPE_KEY = "scope"
    private val AUTH_URL_REDIRECT_URI_KEY = "redirect_uri"
    private val AUTH_URL_APP_ID_KEY = "app_id"

    private val CODE_QUERY_PARAMS_KEY = "code"
    private val TOKEN_AUTHORIZATION_URL = "https://graph.facebook.com/v3.1/oauth/access_token"
    private val USER_INFORMATION_API_URL = "https://graph.facebook.com/me?fields=name,email"
    private val ACCESS_TOKEN_KEY = "access_token"
    private val TOKEN_TYPE_KEY = "token_type"
    private val EXPIRES_IN_KEY = "expires_in"
    private val USER_NAME_KEY = "name"
    private val USER_EMAIL_KEY = "email"

    def buildParamsToAuthUrl: Map[String, Seq[String]] = {
        Map(
            AUTH_URL_APP_ID_KEY -> Seq(oAuthConfigurationService.FACEBOOK_APP_ID),
            AUTH_URL_REDIRECT_URI_KEY -> Seq(oAuthConfigurationService.FACEBOOK_REDIRECT_ENDPOINT),
            AUTH_URL_SCOPE_KEY -> Seq(oAuthConfigurationService.FACEBOOK_ACCESS_SCOPE)
        )
    }

    def isRedirectAuthStringValid(params: Map[String, Seq[String]]): Boolean = {
        if (params.size != 1) {
            return false
        }
        val code = params(CODE_QUERY_PARAMS_KEY)
        if (code == Nil || code.size != 1) {
            return false
        }
        true
    }


    def getTokenFromAuthString(params: Map[String, Seq[String]]): Future[WSResponse] = {
        val code = params(CODE_QUERY_PARAMS_KEY).head
        ws.url(TOKEN_AUTHORIZATION_URL)
            .addHttpHeaders("Content-Type" -> "application/x-www-form-urlencoded")
            .post(getBody(code))
    }

    def validateTokenResponse(response: WSResponse): Boolean = {
        if (response.status != 200) {
            return false
        }
        true
    }

    def getTokenResponse(response: WSResponse): FacebookAuthResponse = {
        val json = response.json
        FacebookAuthResponse(
            (json \ ACCESS_TOKEN_KEY).as[String],
            (json \ TOKEN_TYPE_KEY).as[String],
            (json \ EXPIRES_IN_KEY).as[Long]
        )
    }



    def getUser(facebookAuthResponse: FacebookAuthResponse): Future[FacebookUser] = {
        ws.url(USER_INFORMATION_API_URL)
            .withHttpHeaders(("Authorization", "Bearer " + facebookAuthResponse.accessToken))
            .get()
            .map { response =>
                if (response.status != 200) {
                    None
                }
                getOAuthUser(response, facebookAuthResponse.accessToken)
            }
    }

    private def getBody(code: String) = {
        Map(
            "client_id" -> oAuthConfigurationService.FACEBOOK_APP_ID,
            "redirect_uri" -> oAuthConfigurationService.FACEBOOK_REDIRECT_ENDPOINT,
            "client_secret" -> oAuthConfigurationService.FACEBOOK_CLIENT_SECRET,
            "code" -> code
        )
    }

    private def getOAuthUser(response: WSResponse, token: String) = {
        val json = response.json
        val nameValuePairs = (json \ USER_NAME_KEY).as[String].split(" ")
        FacebookUser(
            nameValuePairs(0),
            nameValuePairs(nameValuePairs.size-1),
            (json \ USER_EMAIL_KEY).as[String]
        )
    }
}
