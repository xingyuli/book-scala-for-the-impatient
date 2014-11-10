package chapter3_array

import scala.collection.mutable.ArrayBuffer

object CommonAlgo {

  def main(args: Array[String]) {
    println(Array(1, 7, 2, 9).sum)
	println(ArrayBuffer("Mary", "has", "a", "little", "lamb").max)
	
	val b = ArrayBuffer(1, 7, 2, 9)
	val bSorted = b.sorted
	println("b: " + b)
	println("bSorted: " + bSorted)
  }

}