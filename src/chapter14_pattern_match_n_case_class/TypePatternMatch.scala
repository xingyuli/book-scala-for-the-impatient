package chapter14_pattern_match_n_case_class

object TypePatternMatch {

  def main(args: Array[String]) {
    val obj = "123"
    println(eval(obj))
  }

  def eval[B](obj: B) = {
     obj match {
      case x: Int => x
      case s: String => Integer.parseInt(s)
      case _: BigInt => Int.MaxValue
      case _ => 0
    }
  }
  
}