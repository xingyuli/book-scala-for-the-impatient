package chapter12_high_order_function

object Curring {

  // normal approach
  def mulOneAtATime(x: Int) = (y: Int) => x * y
  
  // curry approach
  def mul(x: Int)(y: Int) = x * y
  
  def main(args: Array[String]) {
    println(mulOneAtATime(6)(7))
    println(mul(6)(7))
    
    val a = Array("Hello", "World")
    val b = Array("hello", "world")
    val matches = a.corresponds(b)(_.equalsIgnoreCase(_))
    println("matches: " + matches)
  }
  
}