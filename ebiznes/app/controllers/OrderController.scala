package controllers

import java.sql.Timestamp
import java.util.Calendar

import javax.inject.Inject
import models._
import play.api.libs.json.{Json}
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}
import DAOs.{ProductRepository, UserRepository}

import scala.concurrent.{ExecutionContext, Future}

class OrderController @Inject()(productsRepository: ProductRepository,
                                userRepository: UserRepository,
                                cc: MessagesControllerComponents)
                               (implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {


    def addOrder(UserEmail: String): Action[AnyContent] = Action.async { implicit request =>
        println("add order, email: "+UserEmail)
        userRepository.listUserByEmail(UserEmail).flatMap { userOption =>
            if (userOption.isEmpty) {
                Future {
                    Unauthorized("Unknown User")
                    Redirect("http://localhost:4200/notfinishedorder")
                }
            }
            else {
                println(userOption.get)
                if (userOption.get.facebookToken.isEmpty) {
                    Future {
                        Unauthorized("Null Token")
                        Redirect("http://localhost:4200/notfinishedorder")
                    }
                }
                else {
                    productsRepository.list().map { products =>
                        var listofproducts: String = ""
                        var wholePrice: Int = 0
                        for (product <- products) {
                            productsRepository.listBacketItem(product.id).map { backetItem =>
                                var product_str: String = backetItem.get.count + "x" + product.name + " "
                                listofproducts += product_str
                                wholePrice += (product.price * backetItem.get.count)
                            }
                        }
                        Thread.sleep(1000)
                        var newOrder = Order(-1, listofproducts, wholePrice, getTime, userOption.get.id.asInstanceOf[Int])
                        productsRepository.insertOrder(newOrder)
                        Ok(Json.toJson("Order added"))
                        productsRepository.deleteBacket()
                        Redirect("http://localhost:4200/ordersuccess")
                    }
                }
            }
        }
    }
    def prepareOrder(): Action[AnyContent] = Action.async { implicit request =>
        println("prepare order")
        productsRepository.list().map { products =>
            var listofproducts: String = ""
            var wholePrice: Int = 0
            for (product <- products){
                productsRepository.listBacketItem(product.id).map { backetItem =>
                    var product_str: String = backetItem.get.count+"x"+product.name+" "
                    listofproducts += product_str
                    wholePrice += (product.price * backetItem.get.count)
                }
            }
            Thread.sleep(1000)
            var newPreparedOrder = PreparedOrder(listofproducts, wholePrice)
            println(newPreparedOrder)
            Ok(Json.toJson(newPreparedOrder))
        }
    }

    private def getTime = {
        new Timestamp(Calendar.getInstance().getTime.getTime).toString
    }

}