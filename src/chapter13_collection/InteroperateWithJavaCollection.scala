package chapter13_collection

import scala.collection.JavaConversions.propertiesAsScalaMap

object InteroperateWithJavaCollection {

  def main(args: Array[String]) {
    val props: scala.collection.mutable.Map[String, String] = System.getProperties()
    
    props("com.horstman.scala") = "impatient"
    props.foreach(println)
  }
  
}