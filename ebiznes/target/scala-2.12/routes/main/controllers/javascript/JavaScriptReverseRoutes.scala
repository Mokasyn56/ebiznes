// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/huber/ebiznes/conf/routes
// @DATE:Wed Sep 05 17:16:27 CEST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.javascript {

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseBacketController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def addBacketItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BacketController.addBacketItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBacketItem"})
        }
      """
    )
  
    // @LINE:10
    def getBacketItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BacketController.getBacketItems",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getBacketItems"})
        }
      """
    )
  
    // @LINE:11
    def cleanBacket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BacketController.cleanBacket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cleanBacket"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseOrderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def prepareOrder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.prepareOrder",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getPreparedOrder"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseFacebookOAuthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addOrder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacebookOAuthController.addOrder",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addOrder"})
        }
      """
    )
  
    // @LINE:7
    def onFacebookLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacebookOAuthController.onFacebookLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login/facebook"})
        }
      """
    )
  
    // @LINE:6
    def onAuthResponse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacebookOAuthController.onAuthResponse",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/facebook"})
        }
      """
    )
  
    // @LINE:5
    def logoutUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacebookOAuthController.logoutUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout/facebook"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseProductsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getProducts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.getProducts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
        }
      """
    )
  
  }


}
