package chapter12_high_order_function

object AnonymousFunction {

  def main(args: Array[String]) {
    // def triple(x: Double) = 3 * x
    val triple = (x: Double) => 3 * x

    println(Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x).mkString(","))
    // equivalent:
    // println(Array(3.14, 1.42, 2.0).map(3 * _).mkString(","))
  }

}