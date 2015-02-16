package chapter19_parsers.exercise4

import scala.util.parsing.combinator.RegexParsers
import java.util.Date
import java.util.Calendar

object Test extends App {

  // NOTE: time zone not considered here
  class ISO8601DateTimeParser extends RegexParsers {
    
    def datetime: Parser[Date] = date ~ opt("T" ~> time) ^^ { result =>
      def calWithYearMonthDay = result._1 match {
        case y ~ m ~ d => {
          val c = Calendar.getInstance
          c.set(Calendar.YEAR, y)
          c.set(Calendar.MONTH, m - 1)
          c.set(Calendar.DATE, d)
          c 
        }
      }
      
      def calWithHourMinSec(c: Calendar)(h: Int, m: Int, s: Int) = {
        c.set(Calendar.HOUR_OF_DAY, h)
        c.set(Calendar.MINUTE, m)
        c.set(Calendar.SECOND, s)
        c
      }

      result._2 match {
        case None => calWithYearMonthDay.getTime
        case Some(h ~ min ~ s) => calWithHourMinSec(calWithYearMonthDay)(h, min, s).getTime
      }
    }

    def date: Parser[~[~[Int, Int], Int]] = year ~ ((month ~ day) | (("-" ~> month) ~ ("-" ~> day))) ^^ {
      case y ~ (m ~ d) => new ~(new ~(y, m), d)
    }

    def time: Parser[~[~[Int, Int], Int]] = hour ~ ((min ~ sec) | (":" ~> min) ~ (":" ~> sec)) ^^ {
      case h ~ (m ~ s) => new ~(new ~(h, m), s)
    }

    def year: Parser[Int] = "[0-9]{4}".r ^^ { _.toInt }
    def month: Parser[Int] = "(0[0-9])|(1[012])".r ^^ { _.toInt }
    def day: Parser[Int] = "(0[1-9])|([12][0-9])|(3[01])".r ^^ { _.toInt }
    
    def hour: Parser[Int] = "([01][0-9])|(2[0123])".r ^^ { _.toInt }
    def min: Parser[Int] = "[0-5][0-9]".r ^^ { _.toInt }
    def sec: Parser[Int] = "[0-5][0-9]".r ^^ { _.toInt }
    
  }
  
  val parser = new ISO8601DateTimeParser
  val candidates = Array("20150214", "2015-02-14", "2015-0214", "2015-02-14T11:07:00", "2015-02-14T110700")
  for (candidate <- candidates) {
    val result = parser.parseAll(parser.datetime, candidate)
    if (result.successful) println(result.get)
    else println("failed: " + candidate)
  }
  
}