package chapter19_parsers.exercise3

import scala.util.parsing.combinator.RegexParsers

object Test extends App {

  class ListParser extends RegexParsers {
    val integer = "[-]?[0-9]+".r
    def list: Parser[List[Int]] = "(" ~> repsep(elem, ",") <~ ")"
    def elem: Parser[Int] = integer ^^ { _.toInt } 
  }
  
  val parser = new ListParser
  val exprCandidates = Array("(1,23,-79)", "(1, 23, -79)")
  for (exprCandidate <- exprCandidates) {
    val result = parser.parseAll(parser.list, exprCandidate)
    if (result.successful) println(result.get)
  }
  
}