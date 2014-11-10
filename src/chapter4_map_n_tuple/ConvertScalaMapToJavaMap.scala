package chapter4_map_n_tuple

import scala.collection.JavaConversions.mapAsJavaMap

object Conversions {

  def main(args: Array[String]) {
    val scalaMap = Map("Alice" -> 10, "Fred" -> 7, "Bob" -> 3)
    val javaMap = new java.util.HashMap[String, Int]
    javaMap.putAll(scalaMap)
    println("scala map: " + scalaMap)
    println("java map: " + javaMap)
  }
  
}