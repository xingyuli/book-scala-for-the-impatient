package chapter17_type_parameter.exercise3

object Test extends App {

  class Pair[T, S](val t: T, val s: S) {
    def swap(p: (T, S)) = (s, t)
  }
  
}