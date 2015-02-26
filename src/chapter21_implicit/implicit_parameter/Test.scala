package chapter21_implicit.implicit_parameter

object Test extends App {

  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right

  println(quote("Bonjour le monde")(Delimiters("--- ", " ---")))

  import FrenchPunctuation._
  println(quote("Bonjour le monde"))
  
}