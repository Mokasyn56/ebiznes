package models

import java.sql.Timestamp

case class User(id: Long, email: String, facebookToken: Option[String], facebookTokenExpiryDate: Option[Timestamp])