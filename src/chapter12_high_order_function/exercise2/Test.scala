package chapter12_high_order_function.exercise2

import scala.math._

object Test {

  def main(args: Array[String]) {
    val result = Array(1, 3, -1, 4, 9, 7).reduceLeft(max(_, _))
    println("result: " + result)
  }
  
}