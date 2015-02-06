package chapter12_high_order_function.exercise6

import scala.math._

object Test {

  def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(x => (x, fun(x))).reduce { (x: (Int, Int), y: (Int, Int)) =>
      if (x._2 > y._2 ) x
      else y
    }._1
  }
  
  def main(args: Array[String]) {
    println(largestAt(x => 10 * x - x * x, 1 to 10))
  }
  
}