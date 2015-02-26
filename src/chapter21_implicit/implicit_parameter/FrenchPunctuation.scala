package chapter21_implicit.implicit_parameter

object FrenchPunctuation {
  implicit val quoteDelimiters = Delimiters("<<", ">>")
}