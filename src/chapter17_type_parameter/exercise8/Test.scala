package chapter17_type_parameter.exercise8

object Test extends App {
  
  class Pair[T](var first: T, var second: T) {
    // Reason of compile error:
    //   required: T
    //   found: R, which might be super type of T
    // def repalceFirst[R >: T](newFirst: R) { first = newFirst }
  }
  
}