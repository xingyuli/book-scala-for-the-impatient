package chapter3_array

import java.util.TimeZone

import scala.collection.mutable.ArrayBuffer

object Exercise {

  def main(args: Array[String]) {
    println(_1_random_array(10).mkString(","))

    val a = Array(1, 3, 5, 7, 9)
    val b = Array(1, 2, 3, 4, 5, 6)
    _2_swap_neighbour(a)
    _2_swap_neighbour(b)
    println(a.mkString(","))
    println(b.mkString(","))

    val c = Array(1, 3, 5, 7, 9)
    val d = Array(1, 2, 3, 4, 5, 6)
    val swappedC = _3_swap_neighbour(c)
    val swappedD = _3_swap_neighbour(d)
    println("c: " + c.mkString(","))
    println("swappedC: " + swappedC.mkString(","))
    println("d: " + d.mkString(","))
    println("swappedD: " + swappedD.mkString(","))

    val e = Array(-3, 1, 0, -4, 3, 4, 8, -8)
    val processedE = _4_positive_then_negative_followed(e)
    println("e: " + e.mkString(","))
    println("processedE: " + processedE.mkString(","))

    println(_5_average(Array(1.234, 2.345, 3.456, 4.567)))

    // 7
    val f = Array(1, 1, 2, 3, 5, 3)
    val distinctF = f.distinct
    println("f: " + f.mkString(","))
    println("distinctF: " + distinctF.mkString(","))

    println(_8_filterTimeZone() mkString "\n")
  }

  def _1_random_array(size: Int) = {
    val a = new Array[Int](size)
    for (i <- 0 until size) a(i) = (math.random * size).toInt
    a
  }

  def _2_swap_neighbour(a: Array[Int]) {
    for (i <- 0 until a.length if i % 2 == 1) {
      val temp = a(i)
      a(i) = a(i - 1)
      a(i - 1) = temp
    }
  }

  def _3_swap_neighbour(a: Array[Int]) = {
    for (i <- 0 until a.length) yield {
      if (i % 2 == 1) a(i - 1)
      else if (i != a.length - 1) a(i + 1)
      else a(i)
    }
  }

  def _4_positive_then_negative_followed(a: Array[Int]) = {
    val orderedIndexes = new ArrayBuffer[Int]
    orderedIndexes ++= {
      for (i <- 0 until a.length if a(i) > 0) yield i
    }
    orderedIndexes ++= {
      for (i <- 0 until a.length if a(i) <= 0) yield i
    }
    for (index <- orderedIndexes) yield a(index)
  }

  def _5_average(a: Array[Double]) = a.sum / a.size

  def _8_filterTimeZone() = {
    // approach 1
    // val tz = TimeZone.getAvailableIDs.filter(_ startsWith "America/").map(_ stripPrefix "America/")
    // tz.sorted

    // approach 2
    val tz = for (id <- TimeZone.getAvailableIDs; if id startsWith "America/") yield id stripPrefix "America/"
    tz.sorted
  }

}