package chapter13_collection

object ZipOperation {

  def main(args: Array[String]) {
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)
    println(prices zip quantities)
    
    println((prices zip quantities).map { p => p._1 * p._2 })
    
    println(List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1))
    
    println("Scala".zipWithIndex)
  }
  
}