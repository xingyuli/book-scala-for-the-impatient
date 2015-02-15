package chapter19_parsers.exercise1

import scala.util.parsing.combinator.RegexParsers

object Test extends App {

  class ExprParser extends RegexParsers {
    
    val number = "[0-9]+".r
    
    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ expr) ^^ {
      case t ~ Nil => t
      case t ~ r => r.foldLeft(t) { (x: Int, e: ~[String, Int]) =>
        e match {
          case "+" ~ v => x + v
          case "-" ~ v => x - v
        }
      }
    }
    
    def term: Parser[Int] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ {
      case f ~ Nil => f
      case f ~ r => r.foldLeft(f) { (x: Int, e: ~[String, Int]) =>
        e match {
          case "*" ~ v => x * v
          case "/" ~ v => x / v
          case "%" ~ v => x % v
        }
      }
    }
    
    def factor: Parser[Int] = number ^^ { _.toInt } | "(" ~> expr <~ ")"
    
  }
  
  val parser = new ExprParser
  val exprCandidates = Array("3-4*5", "3-8/2", "(3-9)/3", "(12-1)%3")
  for (exprCandidate <- exprCandidates) {
    val result = parser.parseAll(parser.expr, exprCandidate)
    if (result.successful) println(result.get)
  }

}