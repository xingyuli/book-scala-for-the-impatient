package chapter12_high_order_function.exercise3

object Test {

  def factorial(n: Int) = (1 to n).reduceLeft(_*_)
  
  def main(args: Array[String]) {
    println(factorial(5))
    println(factorial(6))
  }
  
}