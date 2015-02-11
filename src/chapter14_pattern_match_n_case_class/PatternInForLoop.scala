package chapter14_pattern_match_n_case_class

import scala.collection.JavaConversions.propertiesAsScalaMap

object PatternInForLoop {

  def main(args: Array[String]): Unit = {
    for ((k, v) <- System.getProperties())
      println(k + " -> " + v)

    println(">>> key has empty value")
    for ((k, "") <- System.getProperties())
      println(k)

    println(">>> key has empty value 1")
    for ((k, v) <- System.getProperties() if v == "")
      println(k)
  }

}