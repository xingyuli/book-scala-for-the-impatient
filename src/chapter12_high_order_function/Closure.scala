package chapter12_high_order_function

object Closure {

  def mulBy(factor: Double) = (x: Double) => factor * x
  
  def main(args: Array[String]) {
    val triple = mulBy(3)
    val half = mulBy(0.5)
    println(triple(14) + " " + half(14))
  }
  
}