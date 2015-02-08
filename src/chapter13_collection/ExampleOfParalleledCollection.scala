package chapter13_collection

object ExampleOfParalleledCollection {

  def main(args: Array[String]) {
    val coll = (1 to 1000000)
    println(coll.par.count(_ % 2 == 0))
    
    for (i <- (0 until 100).par) print(i + " ")
    
    println
    for (i <- (0 until 100)) print(i + " ")
  }
  
}