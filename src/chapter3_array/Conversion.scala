package chapter3_array

object Conversion {

  def main(args: Array[String]) {
    val a = Array(2, 3, 5, 7, 11)
    val result = for (elem <- a) yield 2 * elem
    println(result.mkString(","))

    val b = a.filter(_ % 2 == 0).map(2 * _)
    println(b.mkString(","))
  }

}