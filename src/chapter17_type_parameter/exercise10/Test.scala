package chapter17_type_parameter.exercise10

object Test extends App {

  class Pair[S, T](var s: S, var t: T) {
    // NOTE the way to declare multiple type constraints
    def swap(implicit ev: S =:= T, ev2: T =:= S) {
      val temp = s
      s = t
      t = temp
    }
  }
  
}