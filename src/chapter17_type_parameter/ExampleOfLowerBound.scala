package chapter17_type_parameter

object ExampleOfLowerBound extends App {

  class Pair[T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair[R](newFirst, second)
  }
  
}