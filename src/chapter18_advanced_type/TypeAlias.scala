package chapter18_advanced_type

object TypeAlias extends App {

  import scala.collection.mutable._
  type Index = HashMap[String, (Int, Int)]
  
  var index = new Index
  index("a") = (1, 1)
  index("b") = (2, 2)
  index("c") = (3, 3)
  index ++= Map(("d", (4, 4)), ("e", (5, 5)))
  
  println(index)

}