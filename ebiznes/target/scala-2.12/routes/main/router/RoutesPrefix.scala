// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/huber/ebiznes/conf/routes
// @DATE:Wed Sep 05 17:16:27 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
