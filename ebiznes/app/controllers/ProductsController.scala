package controllers

import javax.inject.Inject
import models._
import play.api.libs.json.{Json}
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}
import DAOs.{ProductRepository}

import scala.concurrent.{ExecutionContext}

class ProductsController @Inject()(productsRepository: ProductRepository,
                                   cc: MessagesControllerComponents)
                                  (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
    def getProducts: Action[AnyContent] = Action.async {
        println("getting products")
        var fullProducts: Set[FullProduct] = Set()
        println("getting backet items")
        productsRepository.list().map { products =>
            for (product <- products){
                productsRepository.listCategoryItem(product.category).map { category =>
                    println("product: "+product)
                    println("backetitem: "+category.get)
                    val newBacketProduct = FullProduct(product.id, product.name, product.description, product.price, category.get.name)
                    fullProducts += newBacketProduct
                }
                println("id: "+product.id)
                println("asjdhasd: "+Json.toJson(fullProducts))
            }
            println(Json.toJson(fullProducts.seq))
            Thread.sleep(1000)
            Ok(Json.toJson(fullProducts.seq))
        }
    }
}
