package chapter13_collection.exercise7

object Test {

  def main(args: Array[String]) {
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)
    
    println((prices zip quantities).map { p => p._1 * p._2 })
    
    val mapper = (x: Double, y: Int) => x * y
    println((prices zip quantities).map(mapper.tupled))
  }
  
}