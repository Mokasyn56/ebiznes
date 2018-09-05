package DAOs

import java.sql.Timestamp

import javax.inject.{Inject, Singleton}
import models._
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}
import scala.language.postfixOps

/**
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class ProductRepository @Inject()(dbConfigProvider: DatabaseConfigProvider, userRepository: UserRepository)(implicit ec: ExecutionContext) {
    val dbConfig = dbConfigProvider.get[JdbcProfile]

    import dbConfig._
    import profile.api._

    class CategoryTable(tag: Tag) extends Table[Category](tag, "category") {

        def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

        def name = column[String]("name")

        def * = (id, name) <> ((Category.apply _).tupled, Category.unapply)
    }

    val category = TableQuery[CategoryTable]


    class ProductTable(tag: Tag) extends Table[Product](tag, "product") {

        def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

        def name = column[String]("name")

        def price = column[Int]("price")

        def description = column[String]("description")

        def category = column[Int]("category")

        def category_fk = foreignKey("cat_fk", category, ProductRepository.this.category)(_.id)

        def * = (id, name, description, price, category) <> ((Product.apply _).tupled, Product.unapply)
    }

    val product = TableQuery[ProductTable]

    class BacketTable(tag: Tag) extends Table[BacketItem](tag, "backet") {

        def product_id = column[Long]("product_id", O.PrimaryKey)

        def count = column[Int]("count")

        def * = (product_id, count) <> ((BacketItem.apply _).tupled, BacketItem.unapply)
    }

    val backet = TableQuery[BacketTable]

    class OrderTable(tag: Tag) extends Table[Order](tag, "order") {

        def id = column[Long]("order_id", O.PrimaryKey, O.AutoInc)

        def products = column[String]("products")

        def price = column[Int]("price")

        def orderDate = column[String]("order_data")

        def purchaserId = column[Int]("purchaser_id")

        def * = (id, products, price, orderDate, purchaserId) <> ((Order.apply _).tupled, Order.unapply)
    }

    val order = TableQuery[OrderTable]


    class UserTable(tag: Tag) extends Table[User](tag, "user") {
        def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
        def email = column[String]("email")
        def facebookToken = column[Option[String]]("facebook_token")
        def facebookTokenExpiryDate = column[Option[Timestamp]]("facebook_token_expiry_date")

        def * = (id, email, facebookToken, facebookTokenExpiryDate) <> ((User.apply _).tupled, User.unapply)
    }
    val user = TableQuery[UserTable]

    /**
      * List all the people in the database.
      */
    def list(): Future[Seq[Product]] = db.run {
        product.result
    }

    def listProduct(productId: Long): Future[Option[Product]] = {
        val query = product.filter(_.id === productId)
        db.run {
            query.result.headOption
        }
    }

    def insertOrder(newOrder: Order): Future[Long] = {
        val orderId =
            (order returning order.map(_.id)) += newOrder
        db.run {
            orderId
        }
    }


    def listBacketItems(): Future[Seq[BacketItem]] = db.run {
        backet.result
    }

    def listBacketItem(productId: Long): Future[Option[BacketItem]] = {
        val query = backet.filter(_.product_id === productId)
        db.run {
            query.result.headOption
        }
    }

    def updateBacketItem(backetItem: BacketItem): Future[Int] = {
        db.run {
            backet.filter(_.product_id === backetItem.productId).update(backetItem)
        }
    }

    def insertBacketItem(newBacketItem: BacketItem): Future[Unit] =
         db.run(backet += newBacketItem).map { _ => () }

    def deleteBacket(): Future[Int] = {
        db.run {
            backet.delete
        }

    }

    def listCategoryItem(categoryId: Int): Future[Option[Category]] = {
        val query = category.filter(_.id === categoryId)
        db.run {
            query.result.headOption
        }
    }

}
