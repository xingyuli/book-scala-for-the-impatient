package chapter17_type_parameter.exercise2

object Test extends App {

  class Pair[T](var first: T, var second: T) {
    def swap = {
      val temp = first
      first = second
      second = temp
    }
  }
  
  val p = new Pair(1, 3)
  println("first: " + p.first + ", second: " + p.second)
  
  p.swap
  println("first: " + p.first + ", second: " + p.second)
  
}