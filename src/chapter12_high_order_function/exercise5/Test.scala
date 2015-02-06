package chapter12_high_order_function.exercise5

import scala.math._

object Test {

  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(fun(_)).reduce(max(_, _))
  }
  
  def main(args: Array[String]) {
    println(largest(x => 10 * x - x * x, 1 to 10))
  }
  
}