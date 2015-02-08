package chapter13_collection

import scala.math._

object ExampleOfView {

  def main(args: Array[String]) {
    val powers = (0 until 1000).view.map { x => println("invoke: " + x); pow(10, x)}
    
    println(powers(100))
    // won't be cached
    println(powers(100))
  }
  
}