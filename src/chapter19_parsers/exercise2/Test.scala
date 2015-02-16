package chapter19_parsers.exercise2

import scala.math._
import scala.util.parsing.combinator.RegexParsers

object Test extends App {

  // NOTE: this is also the answer for exercise 7
  class ExprParser extends RegexParsers {
    
    val number = "[0-9]+".r
    
    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ expr) ^^ {
      case t ~ Nil => t
      case t ~ r => r.foldLeft(t) { (acc, e) =>
        e match {
          case "+" ~ v => acc + v
          case "-" ~ v => acc - v
        }
      }
    }
    
    def term: Parser[Int] = _pow ~ rep(("*" | "/" | "%") ~ _pow) ^^ {
      case p ~ Nil => p
      case p ~ r => r.foldLeft(p) { (acc, e) =>
        e match {
          case "*" ~ v => acc * v
          case "/" ~ v => acc / v
          case "%" ~ v => acc % v
        }
      }
    }
    
    def _pow: Parser[Int] = factor ~ rep("^" ~> factor) ^^ {
      case f ~ Nil => f
      case f ~ r => (f :: r).reduceRight(pow(_, _).toInt)
    }
    
    def factor: Parser[Int] = number ^^ { _.toInt } | "(" ~> expr <~ ")"
    
  }
  
  val parser = new ExprParser
  val exprCandidates = Array("4^2^3", "4^2^3*3")
  for (exprCandidate <- exprCandidates) {
    val result = parser.parseAll(parser.expr, exprCandidate)
    if (result.successful) println(result.get)
  }

}