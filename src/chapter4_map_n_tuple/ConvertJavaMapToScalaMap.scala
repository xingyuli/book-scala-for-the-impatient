package chapter4_map_n_tuple

import scala.collection.JavaConversions.mapAsScalaMap

object ConvertJavaMapToScalaMap {

  def main(args: Array[String]) {
    val map = new java.util.HashMap[String, Integer]
    map += ("a" -> 1, "b" -> 2)
    println("java map: " + map)
    
    val propMap = System.getProperties
    println("system props: " + propMap)
  }
  
}