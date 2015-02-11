package chapter14_pattern_match_n_case_class

object CaseClass {

  abstract class Amount
  
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  
  case object Nothing extends Amount
  
  def main(args: Array[String]): Unit = {
    println(testAmt(Dollar(3)))
    println(testAmt(Currency(3, "CNY")))
    println(testAmt(Nothing))
    
    // copy with named parameter
    val amt = Currency(29.95, "EUR")
    val price = amt.copy(value = 19.95)
    val price1 = amt.copy(unit = "CHF")
    
    val (h, t) = testList(List(1, 2, 3))
    println("h: " + h + ", t: " + t)
  }
  
  private def testAmt(amt: Amount) = {
    amt match {
      case Dollar(v) => "$" + v
      case Currency(_, u) => "Oh noes, I got " + u
      case Nothing => ""
    }
  }
  
  private def testList[E](lst: List[E]) = {
    lst match {
      case h :: t => (h, t) // equivalent to: case ::(h, t)
      case _ => (Nil, Nil)
    }
  }
  
}