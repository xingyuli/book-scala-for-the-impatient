package chapter13_collection

import java.awt.Color
import scala.collection.immutable.SortedSet

object MainTraitsOfCollection {

  def main(args: Array[String]) {
    println(Iterable(0xFF, 0xFF00, 0xFF0000).mkString(", "))
    println(Set(Color.RED, Color.GREEN, Color.BLUE).mkString(", "))
    println(Map(Color.RED -> 0xFF0000, Color.GREEN -> 0xFF00, Color.BLUE -> 0xFF).mkString(", "))
    println(SortedSet("Hello", "World").mkString(", "))
  }
  
}