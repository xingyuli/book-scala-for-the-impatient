package chapter21_implicit.implicit_conversion

import scala.annotation.tailrec

case class Fraction(val n: Int, val m: Int) {
  def *(operand: Fraction): Fraction = Fraction(n * operand.n, m * operand.m)
}

object Fraction {

  implicit def int2Fraction(n: Int) = new Fraction(n, 1)
  
  // How to let the function
  //   smaller[T](a: T, b: T)(implicit order: T => Ordered[T])
  // works for Fraction?
  // Provide a function whose signature is: T => Ordered[T]
  implicit val fraction2OrderedFraction = {
    @tailrec def gcd(m: Int, n: Int): Int = if (n == 0) m else gcd(n, m % n)
    
    def toOrdered(f: Fraction): Ordered[Fraction] = new Ordered[Fraction] {
      override def compare(that: Fraction): Int = {
        val lcm = f.m * that.m / gcd(f.m, that.m)
        f.n * (lcm / f.m) - that.n * (lcm / that.m)
      }
    }
    toOrdered _
  }
  
}

