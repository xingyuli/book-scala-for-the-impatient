package chapter13_collection.exercise5

object Test {

  def mkString[B](c: Iterable[B])(start: String, sep: String, end: String) = {
    start + c.map(_.toString).reduceLeft(_.toString + sep + _.toString) + end
  }
 
  def main(args: Array[String]) {
    println(List(1, 2, 3).mkString("<<", "_", ">>"))
    println(mkString(List(1, 2, 3))("<<", "_", ">>"))
  }
  
}