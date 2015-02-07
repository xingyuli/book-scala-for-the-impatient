package chapter13_collection.exercise1

import scala.collection.mutable
import scala.collection.mutable.LinkedHashSet

object Test {

  def indexes(s: String) = (Map[Char, mutable.Set[Int]]() /: s.zipWithIndex) {
    (m, p) => m + (p._1 -> (m.getOrElse(p._1, LinkedHashSet[Int]()) + p._2))
  }

  def main(args: Array[String]) {
    println(indexes("Mississippi"))
  }
  
}