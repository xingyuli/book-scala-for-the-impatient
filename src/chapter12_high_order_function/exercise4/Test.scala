package chapter12_high_order_function.exercise4

object Test {

  def factorial(n: Int) = (1 to n).foldLeft(1)(_*_)
  
  def main(args: Array[String]) {
    // key point: (1 to -1) returns Range()
    println(factorial(-1))

    println(factorial(5))
    println(factorial(6))
  }
  
}