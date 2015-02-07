package chapter13_collection.exercise4

object Test {

  def myFunc(c: Iterable[String], m: Map[String, Int]) = c.flatMap(m.get(_))
  
  def main(args: Array[String]) {
    val c = Array("Tom", "Fred", "Harry")
    val m = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
    println(myFunc(c, m))
    
    println(List(Some(3), None, Some(5)))
    println(List(Some(3), None, Some(5)).seq)
  }
  
}