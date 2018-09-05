package DAOs

import java.sql.Timestamp

import javax.inject.Inject
import models.User
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

class UserRepository  @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {


    val dbConfig = dbConfigProvider.get[JdbcProfile]

    import dbConfig._
    import profile.api._

    class UserTable(tag: Tag) extends Table[User](tag, "user") {
        def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
        def email = column[String]("email")
        def facebookToken = column[Option[String]]("facebook_token")
        def facebookTokenExpiryDate = column[Option[Timestamp]]("facebook_token_expiry_date")

        def * = (id, email, facebookToken, facebookTokenExpiryDate) <> ((User.apply _).tupled, User.unapply)
    }
    val user = TableQuery[UserTable]

    def listUserByEmail(email: String) = db.run {
        user.filter(_.email === email).result.headOption
    }

    def updateUser(updateUser: User) = db.run {
        user.update(updateUser)
    }

    def addNewUser(newUser: User) = db.run {
        user += newUser
    }

}
