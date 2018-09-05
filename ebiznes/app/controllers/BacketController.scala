package controllers

import javax.inject.Inject
import models.{BacketItem, BacketProduct}
import play.api.libs.json.{Json}
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}
import DAOs.{ProductRepository}

import scala.concurrent.{ExecutionContext}

class BacketController  @Inject()(productsRepository: ProductRepository,
                                   cc: MessagesControllerComponents)
                                  (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
  def getBacketItems: Action[AnyContent] = Action.async {
    var backetProducts: Set[BacketProduct] = Set()
    println("getting backet items")
    productsRepository.list().map { products =>
        for (product <- products){

          productsRepository.listBacketItem(product.id).map { backetItem =>
            println("product: "+product)
            println("backetitem: "+backetItem.get)
            val newBacketProduct = BacketProduct(product.name, backetItem.get.count, product.price * backetItem.get.count)
            backetProducts += newBacketProduct
          }
          println("id: "+product.id)
          println("asjdhasd: "+Json.toJson(backetProducts))
          }
      println(Json.toJson(backetProducts.seq))
      Thread.sleep(1000)
      Ok(Json.toJson(backetProducts.seq))
        }
      }

  def addBacketItem: Action[AnyContent] = Action.async { implicit request =>
    val json = request.body.asJson.get
    println("adding backet items: "+json)
    val backetItem = json.as[BacketItem]
    println("adding backet 1231231items: "+backetItem.productId)
    productsRepository.listBacketItem(backetItem.productId).map { backetItemOption =>
      if (backetItemOption.isEmpty) {
          val backetItemInsert = BacketItem(backetItem.productId, 1)
          productsRepository.insertBacketItem(backetItemInsert)
          Ok(Json.toJson("backet item added"))
      } else {
        val existingBacketItem = backetItemOption.get
        val newCount = (existingBacketItem.count + 1)
        val backetItemUpdate = BacketItem(existingBacketItem.productId, newCount)
        productsRepository.updateBacketItem(backetItemUpdate)
        Ok(Json.toJson("backet item updated"))
      }
    }
  }

  def cleanBacket: Action[AnyContent] = Action.async {
    productsRepository.deleteBacket().map { res =>
      Ok("Backet Cleaned")
      Redirect("http://localhost:4200/basket")
    }
  }

}