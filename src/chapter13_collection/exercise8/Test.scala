package chapter13_collection.exercise8

object Test {

  def myGrouped(a: Array[Double])(colNum: Int) = a.grouped(colNum).toArray
  
  def main(args: Array[String]) {
    myGrouped(Array(1, 2, 3, 4, 5, 6))(3) foreach {
      a => println(a.toList mkString ", ")
    }
  }
  
}