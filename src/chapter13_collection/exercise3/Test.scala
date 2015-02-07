package chapter13_collection.exercise3

import scala.collection.mutable.LinkedList

object Test {

  def without[B](b: B)(l: LinkedList[B]) = l.filter(_ != b)
  
  def main(args: Array[String]) {
    println(without(0)(LinkedList(1, 0, -1, 2, 0, -2)))
  }
  
}