package chapter14_pattern_match_n_case_class

object SealedClass extends App {

  sealed abstract class Amount

  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  
  def stringOfAmt(amt: Amount) = amt match {
    case Dollar(v) => "$" + v
    case Currency(_, u) => "Oh noes, I got " + u
  }

  println("stringOfAmt: " + stringOfAmt(Dollar(3)))
  
  // monitoring enumerations
  sealed abstract class TrafficLightColor
  case object Red extends TrafficLightColor
  case object Yellow extends TrafficLightColor
  case object Green extends TrafficLightColor

  def tipOfTrafficLightColor(t: TrafficLightColor) = t match {
    case Red => "stop"
    case Yellow => "hurry up"
    case Green => "go"
  }

  println("TrafficLight says: " + tipOfTrafficLightColor(Red))
  
}