package chapter12_high_order_function

import scala.math._

object AcceptFunctionParameter {

  // ((Double) => Double) => Double
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  
  // (Double) => ((Double) => Double)
  def mulBy(factor: Double) = (x: Double) => factor * x
  
  def main(args: Array[String]) {
    println(valueAtOneQuarter(ceil))
    println(valueAtOneQuarter(sqrt))
    
    val quintuple = mulBy(5)
    println(quintuple(20))
  }
  
}