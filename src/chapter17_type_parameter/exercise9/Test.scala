package chapter17_type_parameter.exercise9

import scala.math._

object Test extends App {

  /*
  class Pair[+T](val first: T, val second: T) {
    // COMPILE ERROR: covariant T occurs at invariant point
    def replaceFirst(newFirst: T) = new Pair(newFirst, second)
  }

  class NastyDoublePair(override val first: Double, override val second: Double)
      extends Pair(first, second) {
    override def replaceFirst(newFirst: Double) = new Pair(sqrt(newFirst), second)
  }
  
  val p: Pair[Any] = new NastyDoublePair(1.0, 2.0)
  p.replaceFirst("Hello")
  */
  
  /*
  class Pair[+T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair(newFirst, second)
  }

  class NastyDoublePair(override val first: Double, override val second: Double)
      extends Pair(first, second) {
    // COMPILE ERROR: overrides nothing
    override def replaceFirst[R >: Double](newFirst: Double) = new Pair(sqrt(newFirst), second)
  }
  */

  class Pair[+T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair(newFirst, second)
  }

  class NastyDoublePair(override val first: Double, override val second: Double)
      extends Pair(first, second) {
  }
  
  val pDouble = new NastyDoublePair(1.0, 2.0)

  val pAny: Pair[Any] = pDouble
  val p1 = pAny.replaceFirst("Hello")
  println("p1.first: " + p1.first)
  println("p1.second: " + p1.second)
  
  println("pDouble.first: " + pDouble.first)
  println("pDouble.second: " + pDouble.second)
}