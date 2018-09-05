package services

import java.sql.Timestamp
import java.util.Calendar

import DAOs.UserRepository
import javax.inject.Inject
import models.User

import scala.concurrent.{ExecutionContext, Future}

class AuthenticationService @Inject()(userRepository: UserRepository)
                                     (implicit ec: ExecutionContext) {

    def addFacebookUser(email: String, token: String): Future[User] = {
        userRepository.listUserByEmail(email).flatMap { userOption =>
            if (userOption.isDefined) {
                val user = userOption.get
                val userToUpdate = User(user.id, user.email, Option(token), Option(getTokenExpiry))
                userRepository.updateUser(userToUpdate)
                Future {
                    userToUpdate
                }
            } else {
                val newUser = User(-1, email, Option(token), Option(getTokenExpiry))
                userRepository.addNewUser(newUser)
                Future {
                    newUser
                }
            }
        }
    }

    private def getTokenExpiry = {
        new Timestamp(Calendar.getInstance().getTimeInMillis)
    }

}
