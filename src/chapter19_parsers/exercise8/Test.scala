package chapter19_parsers.exercise8

import scala.math._
import scala.util.parsing.combinator.RegexParsers

object Test extends App {

  class ExprParser extends RegexParsers {
    
    val ident = "[a-zA-Z_][a-zA-Z0-9_]*".r
    val number = "[0-9]+".r

    private val variables = scala.collection.mutable.Map[String, Int]()
    
    def assignment: Parser[Int] = identifier ~ opt("=" ~> (expr | identifier) ^^ {
      case e: Int => e
      case i: String => variables.getOrElse(i, -1)
    }) ^^ {
      case "out" ~ Some(v) => println(v); v
      case i ~ None => variables(i) = 0; 0
      case i ~ Some(v) => variables(i) = v; v
    }

    def identifier: Parser[String] = ident
      
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
  val candidates = Array("a=134-4", "out=a")
  for (candidate <- candidates) {
    parser.parseAll(parser.assignment, candidate)
  }
  
}