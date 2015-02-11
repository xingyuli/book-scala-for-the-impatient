package chapter14_pattern_match_n_case_class.exercise4

object Test extends App {

  sealed abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  case class Multiple(quantities: Int, items: Item*) extends Item
  
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    case Multiple(q, its @ _*) => its.map(price _).sum * q
  }

  val a = Article("Hello World", 10.0)
  println("price of a: " + price(a))
  
  val b = Bundle("Father's day special", 20.0,
    Article("Scala for the impatient", 39.95),
    Bundle("Anchor Distillery Sampler", 10.0,
        Article("Old Potrero Straight Rye Whisky", 79.95)))
  println("price of b: " + price(b))

  val m = Multiple(3, a, b)
  println("price of m: " + price(m))
  
}