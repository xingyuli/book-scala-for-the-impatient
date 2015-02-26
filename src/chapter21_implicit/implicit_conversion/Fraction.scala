package chapter21_implicit.implicit_conversion

case class Fraction(val n: Int, val m: Int) {
  def *(operand: Fraction): Fraction = Fraction(n * operand.n, m * operand.m)
}

object Fraction {
  implicit def int2Fraction(n: Int) = new Fraction(n, 1)
}
