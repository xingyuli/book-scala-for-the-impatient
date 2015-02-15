package chapter19_parsers

import scala.util.parsing.combinator.RegexParsers

object Example4OfGeneratingParsingTree extends App {
  
  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r
    
    def expr: Parser[Expr] = term ~ opt(("+" | "-") ~ expr) ^^ {
      case t ~ None => t
      case t ~ Some("+" ~ e) => Operator("+", t, e)
      case t ~ Some("-" ~ e) => Operator("-", t, e)
    }

    def term: Parser[Expr] = factor ~ opt("*" ~> term) ^^ {
      case a ~ None => a
      case a ~ Some(b) => Operator("*", a, b)
    }
    
    def factor: Parser[Expr] = number ^^ { n => Number(n.toInt) } | "(" ~> expr <~ ")" 
  }

  class Expr
  case class Number(value: Int) extends Expr
  case class Operator(op: String, left: Expr, right: Expr) extends Expr
  
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if (result.successful) println(result.get)
  
}