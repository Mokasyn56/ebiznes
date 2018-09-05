package models

import play.api.libs.json._

case class FullProduct(id: Long, name: String, description: String, price: Int, category: String)

object FullProduct {
  implicit val productFormat = Json.format[FullProduct]
}
