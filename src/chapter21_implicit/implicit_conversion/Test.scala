package chapter21_implicit.implicit_conversion

import RichFileConversions._

import java.io.File

object Test extends App {

  val result = 3 * Fraction(4, 5)
  println(result)
  
  val contents = new File("src/chapter21_implicit/implicit_conversion/test.txt").read
  println(contents)
  
}