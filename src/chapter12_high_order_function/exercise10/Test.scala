package chapter12_high_order_function.exercise10

object Test {

  // condition: call-by-value is enough, as condition won't be changed
  // block: MUST be call-by-name, otherwise it will ALWAYS be executed
  def unless(condition: Boolean)(block: => Unit) {
    if (!condition) {
      block
    }
  }
  
  def main(args: Array[String]) {
    val isFriday = false
    unless(isFriday) {
      println("Tomorrow is Saturday!")
    }
  }
  
}