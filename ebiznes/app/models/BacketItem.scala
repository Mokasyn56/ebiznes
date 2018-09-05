package models

import play.api.libs.json.{Json, OFormat}

case class BacketItem(productId: Long, count: Int)

object BacketItem {
    implicit val backetFormat: OFormat[BacketItem] = Json.format[BacketItem]

    def map(id: Long, count: Int) = new BacketItem(id, count)
}