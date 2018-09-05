package models

import play.api.libs.json.Json

case class BacketProduct(name: String, count: Int, price: Int) {}
object BacketProduct {
  implicit val backetProductFormat = Json.format[BacketProduct]

  def map(name: String, count: Int, price: Int): BacketProduct =
    new BacketProduct(name, count, price)
}