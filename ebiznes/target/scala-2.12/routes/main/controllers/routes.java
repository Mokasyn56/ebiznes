// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/huber/ebiznes/conf/routes
// @DATE:Wed Sep 05 17:16:27 CEST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBacketController BacketController = new controllers.ReverseBacketController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseOrderController OrderController = new controllers.ReverseOrderController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFacebookOAuthController FacebookOAuthController = new controllers.ReverseFacebookOAuthController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseProductsController ProductsController = new controllers.ReverseProductsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBacketController BacketController = new controllers.javascript.ReverseBacketController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseOrderController OrderController = new controllers.javascript.ReverseOrderController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFacebookOAuthController FacebookOAuthController = new controllers.javascript.ReverseFacebookOAuthController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseProductsController ProductsController = new controllers.javascript.ReverseProductsController(RoutesPrefix.byNamePrefix());
  }

}
