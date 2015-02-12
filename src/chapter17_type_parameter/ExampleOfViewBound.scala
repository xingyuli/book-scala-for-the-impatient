package chapter17_type_parameter

object ExampleOfViewBound extends App {

  class Pair[T <% Comparable[T]](val first: T, val second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }
  
  val p = new Pair(4, 2)
  println(p.smaller)
  
}