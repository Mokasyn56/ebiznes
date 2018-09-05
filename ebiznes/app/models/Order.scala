package models

import java.sql.Timestamp

import play.api.libs.json.{Json, OFormat}

case class Order(id: Long, products: String, price: Int, orderDate: String, pourchaserId: Int)

object Order {
    implicit val orderFormat: OFormat[Order] = Json.format[Order]
}
