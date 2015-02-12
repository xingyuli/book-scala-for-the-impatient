package chapter17_type_parameter

object GenericClass extends App {

  class Pair[T, S](val first: T, val second: S)
  
  val p = new Pair[Int, String](1, "one")
  
  println(p.first)
  println(p.second)
  
}