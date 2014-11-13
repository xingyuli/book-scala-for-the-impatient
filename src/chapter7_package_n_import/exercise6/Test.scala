package chapter7_package_n_import.exercise6

import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}
import scala.collection.JavaConversions.mapAsScalaMap

object Test extends App {

  val jMap = new JavaHashMap[String, String]
  jMap.put("one", "aaa")
  jMap.put("two", "bbb")
  jMap.put("three", "ccc")

  val sMap = new ScalaHashMap[String, String]
  for((k, v) <- jMap) sMap(k) = v
  
  println(sMap)

}