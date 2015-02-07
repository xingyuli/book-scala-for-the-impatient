package chapter13_collection

object MappingOperationOfCollection {

  def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)
  
  def main(args: Array[String]) {
    val names = List("Peter", "Paul", "Mary")
    
    println(names.map(_.toUpperCase))
    
    println(names.map(ulcase))
    println(names.flatMap(ulcase))
    
    println("-3+4".collect { case '+' => 1; case '-' => -1 })
  }
  
}