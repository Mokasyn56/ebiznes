package services

import javax.inject.Inject
import play.api.Configuration

class OAuthConfigurationService @Inject() (config: Configuration) {
  //  ---> facebook
  val FACEBOOK_APP_ID: String = config.get[String]("facebook.app.id")
  val FACEBOOK_CLIENT_SECRET: String = config.get[String]("facebook.client.secret")
  val FACEBOOK_REDIRECT_URL: String = config.get[String]("facebook.redirect.url")
  val FACEBOOK_REDIRECT_ENDPOINT: String = config.get[String]("facebook.redirect.endpoint")
  val FACEBOOK_ACCESS_SCOPE: String = config.get[String]("facebook.access.scope")
}
