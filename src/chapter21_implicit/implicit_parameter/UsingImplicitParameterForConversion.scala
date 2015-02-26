package chapter21_implicit.implicit_parameter

import chapter21_implicit.implicit_conversion.Fraction

object UsingImplicitParameterForConversion extends App {

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = {
    // if (order(a) < b) a else b
    
    // OK, as well!    
    if (a < b) a else b
  }
  
  println(smaller(40, 2))
  println(smaller("Hello", "World"))
  
  println(smaller(Fraction(1, 7), Fraction(2, 9)))
}