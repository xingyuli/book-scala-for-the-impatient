package chapter17_type_parameter.exercise1

object Test extends App {

  class Pair[T, S](val t: T, val s: S) {
    def swap = new Pair(s, t)
  }

  val p = new Pair(1, "one")
  val p1 = p.swap

}