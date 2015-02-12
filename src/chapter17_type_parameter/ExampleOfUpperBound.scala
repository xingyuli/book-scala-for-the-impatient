package chapter17_type_parameter

object BoundOfTypeParameter extends App {

  class Pair[T <: Comparable[T]](val first: T, val second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }
  
  val p = new Pair("Fred", "Brooks")
  println(p.smaller)
  
}