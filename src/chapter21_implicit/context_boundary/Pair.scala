package chapter21_implicit.context_boundary

import chapter21_implicit.implicit_conversion.Fraction

class Pair[T : Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]) = {
    if (ord.compare(first, second) < 0) first else second
  }
}

object Main extends App {
  val p = new Pair(Fraction(1, 7), Fraction(2, 9))
  println(p.smaller)
}