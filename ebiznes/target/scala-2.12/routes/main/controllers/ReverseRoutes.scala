// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/huber/ebiznes/conf/routes
// @DATE:Wed Sep 05 17:16:27 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:16
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:9
  class ReverseBacketController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def addBacketItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addBacketItem")
    }
  
    // @LINE:10
    def getBacketItems(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getBacketItems")
    }
  
    // @LINE:11
    def cleanBacket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cleanBacket")
    }
  
  }

  // @LINE:12
  class ReverseOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def prepareOrder(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getPreparedOrder")
    }
  
  }

  // @LINE:5
  class ReverseFacebookOAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def addOrder(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addOrder")
    }
  
    // @LINE:7
    def onFacebookLogin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login/facebook")
    }
  
    // @LINE:6
    def onAuthResponse(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "auth/facebook")
    }
  
    // @LINE:5
    def logoutUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout/facebook")
    }
  
  }

  // @LINE:8
  class ReverseProductsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getProducts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
  }


}
