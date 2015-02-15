package chapter19_parsers

import scala.util.parsing.combinator.RegexParsers

object Example1OfParserCombinators extends App {

  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    
    def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
    def term: Parser[Any] = factor ~ rep("*" ~ factor)
    def factor: Parser[Any] = number | "(" ~ expr ~ ")"
  }
  
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if (result.successful) println(result.get)
  
}