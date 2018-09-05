// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/huber/ebiznes/conf/routes
// @DATE:Wed Sep 05 17:16:27 CEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  FacebookOAuthController_1: controllers.FacebookOAuthController,
  // @LINE:8
  ProductsController_3: controllers.ProductsController,
  // @LINE:9
  BacketController_0: controllers.BacketController,
  // @LINE:12
  OrderController_4: controllers.OrderController,
  // @LINE:16
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    FacebookOAuthController_1: controllers.FacebookOAuthController,
    // @LINE:8
    ProductsController_3: controllers.ProductsController,
    // @LINE:9
    BacketController_0: controllers.BacketController,
    // @LINE:12
    OrderController_4: controllers.OrderController,
    // @LINE:16
    Assets_2: controllers.Assets
  ) = this(errorHandler, FacebookOAuthController_1, ProductsController_3, BacketController_0, OrderController_4, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FacebookOAuthController_1, ProductsController_3, BacketController_0, OrderController_4, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout/facebook""", """controllers.FacebookOAuthController.logoutUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """auth/facebook""", """controllers.FacebookOAuthController.onAuthResponse"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login/facebook""", """controllers.FacebookOAuthController.onFacebookLogin"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductsController.getProducts"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addBacketItem""", """controllers.BacketController.addBacketItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBacketItems""", """controllers.BacketController.getBacketItems"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cleanBacket""", """controllers.BacketController.cleanBacket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getPreparedOrder""", """controllers.OrderController.prepareOrder"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addOrder""", """controllers.FacebookOAuthController.addOrder"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_FacebookOAuthController_logoutUser0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout/facebook")))
  )
  private[this] lazy val controllers_FacebookOAuthController_logoutUser0_invoker = createInvoker(
    FacebookOAuthController_1.logoutUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacebookOAuthController",
      "logoutUser",
      Nil,
      "GET",
      this.prefix + """logout/facebook""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_FacebookOAuthController_onAuthResponse1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("auth/facebook")))
  )
  private[this] lazy val controllers_FacebookOAuthController_onAuthResponse1_invoker = createInvoker(
    FacebookOAuthController_1.onAuthResponse,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacebookOAuthController",
      "onAuthResponse",
      Nil,
      "GET",
      this.prefix + """auth/facebook""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_FacebookOAuthController_onFacebookLogin2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login/facebook")))
  )
  private[this] lazy val controllers_FacebookOAuthController_onFacebookLogin2_invoker = createInvoker(
    FacebookOAuthController_1.onFacebookLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacebookOAuthController",
      "onFacebookLogin",
      Nil,
      "GET",
      this.prefix + """login/facebook""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ProductsController_getProducts3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductsController_getProducts3_invoker = createInvoker(
    ProductsController_3.getProducts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "getProducts",
      Nil,
      "GET",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_BacketController_addBacketItem4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addBacketItem")))
  )
  private[this] lazy val controllers_BacketController_addBacketItem4_invoker = createInvoker(
    BacketController_0.addBacketItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BacketController",
      "addBacketItem",
      Nil,
      "POST",
      this.prefix + """addBacketItem""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_BacketController_getBacketItems5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBacketItems")))
  )
  private[this] lazy val controllers_BacketController_getBacketItems5_invoker = createInvoker(
    BacketController_0.getBacketItems,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BacketController",
      "getBacketItems",
      Nil,
      "GET",
      this.prefix + """getBacketItems""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_BacketController_cleanBacket6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cleanBacket")))
  )
  private[this] lazy val controllers_BacketController_cleanBacket6_invoker = createInvoker(
    BacketController_0.cleanBacket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BacketController",
      "cleanBacket",
      Nil,
      "GET",
      this.prefix + """cleanBacket""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_OrderController_prepareOrder7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPreparedOrder")))
  )
  private[this] lazy val controllers_OrderController_prepareOrder7_invoker = createInvoker(
    OrderController_4.prepareOrder,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "prepareOrder",
      Nil,
      "GET",
      this.prefix + """getPreparedOrder""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_FacebookOAuthController_addOrder8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addOrder")))
  )
  private[this] lazy val controllers_FacebookOAuthController_addOrder8_invoker = createInvoker(
    FacebookOAuthController_1.addOrder,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacebookOAuthController",
      "addOrder",
      Nil,
      "GET",
      this.prefix + """addOrder""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_FacebookOAuthController_logoutUser0_route(params@_) =>
      call { 
        controllers_FacebookOAuthController_logoutUser0_invoker.call(FacebookOAuthController_1.logoutUser)
      }
  
    // @LINE:6
    case controllers_FacebookOAuthController_onAuthResponse1_route(params@_) =>
      call { 
        controllers_FacebookOAuthController_onAuthResponse1_invoker.call(FacebookOAuthController_1.onAuthResponse)
      }
  
    // @LINE:7
    case controllers_FacebookOAuthController_onFacebookLogin2_route(params@_) =>
      call { 
        controllers_FacebookOAuthController_onFacebookLogin2_invoker.call(FacebookOAuthController_1.onFacebookLogin)
      }
  
    // @LINE:8
    case controllers_ProductsController_getProducts3_route(params@_) =>
      call { 
        controllers_ProductsController_getProducts3_invoker.call(ProductsController_3.getProducts)
      }
  
    // @LINE:9
    case controllers_BacketController_addBacketItem4_route(params@_) =>
      call { 
        controllers_BacketController_addBacketItem4_invoker.call(BacketController_0.addBacketItem)
      }
  
    // @LINE:10
    case controllers_BacketController_getBacketItems5_route(params@_) =>
      call { 
        controllers_BacketController_getBacketItems5_invoker.call(BacketController_0.getBacketItems)
      }
  
    // @LINE:11
    case controllers_BacketController_cleanBacket6_route(params@_) =>
      call { 
        controllers_BacketController_cleanBacket6_invoker.call(BacketController_0.cleanBacket)
      }
  
    // @LINE:12
    case controllers_OrderController_prepareOrder7_route(params@_) =>
      call { 
        controllers_OrderController_prepareOrder7_invoker.call(OrderController_4.prepareOrder)
      }
  
    // @LINE:13
    case controllers_FacebookOAuthController_addOrder8_route(params@_) =>
      call { 
        controllers_FacebookOAuthController_addOrder8_invoker.call(FacebookOAuthController_1.addOrder)
      }
  
    // @LINE:16
    case controllers_Assets_versioned9_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
