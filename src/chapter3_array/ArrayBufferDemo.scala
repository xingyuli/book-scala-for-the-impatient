package chapter3_array

import scala.collection.mutable.ArrayBuffer

object ArrayBufferDemo {

  def main(args: Array[String]) {
    val b = ArrayBuffer[Int]()

    b += 1
    println(b)

    b +=(1, 2, 3, 5)
    println(b)

    b ++= Array(8, 13, 21)
    println(b)

    b.trimEnd(5)
    println(b)

    b.insert(2, 6)
    println(b)

    b.insert(2, 7, 8, 9)
    println(b)

    b.remove(2)
    println(b)

    b remove(2, 3)
    println(b)
  }

}