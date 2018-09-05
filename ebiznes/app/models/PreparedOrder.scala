package models

import play.api.libs.json.Json

case class PreparedOrder(products: String, price: Int)

object PreparedOrder {
    implicit val format = Json.format[PreparedOrder]
}