package chapter12_high_order_function

import scala.math._

object FunctionAsValue {

  def main(args: Array[String]) {
    val num = 3.14
    val fun = ceil _
    
    println("fun: " + fun)
    
    println(fun(num))
    println(Array(3.14, 1.42, 2.0).map(fun).mkString(","))
  }

}