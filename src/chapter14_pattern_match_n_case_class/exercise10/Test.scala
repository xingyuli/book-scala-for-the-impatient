package chapter14_pattern_match_n_case_class.exercise10

import scala.math._

object Test extends App {

  def compose(f: (Double) => Option[Double], g: (Double) => Option[Double]) = {
    (x: Double) => (f(x), g(x)) match {
      case (None, _) => None
      case (_, None) => None
      case (_, gr) => gr
    }
  }
  
  def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  
  def h = compose(f, g)
  
  println(h(2))
  println(h(1))
  println(h(0))
  
}