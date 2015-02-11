package chapter14_pattern_match_n_case_class

object MatchNestedStructures extends App {

  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
  }
  
  val b = Bundle("Father's day special", 20.0,
      Article("Scala for the impatient", 39.95),
      Bundle("Anchor Distillery Sampler", 10.0,
          Article("Old Potrero Straight Rye Whisky", 79.95)))

  println("price of b: " + price(b))

}