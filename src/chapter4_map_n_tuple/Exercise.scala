package chapter4_map_n_tuple

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap

object Exercise {

  def main(args: Array[String]) {
    _1_discount_devices

    _2_count_words_using_scala_mutable_Map
    _3_count_words_using_scala_immutable_Map
    _4_count_words_using_scala_SortedMap
    _5_count_words_using_java_TreeMap

    _6_store_weekday_using_scala_LinkedHashMap

    _7_print_system_properties

    val a = Array(1, 3, -9, 8, 22, 19)
    val (min, max) = _8_minmax(a)
    println("a: " + a.mkString(", "))
    println("min: " + min + ", max: " + max)

    val b = Array(1, 4, 2, 6, 3, 7, 2, 8, 9, 3, 7, 3)
    val (ltCount, eqCount, gtCount) = _9_lteqgt(b, 3)
    println("b: " + b.mkString(", "))
    printf("ltCount: %d, eqCount: %d, gtCount: %d%n", ltCount, eqCount, gtCount)

    _10_zip_string
  }

  private def _1_discount_devices: Unit = {
    val devices = Map("Calibrator" -> 9999.0, "Knife" -> 1000.0, "Coat" -> 5000.0)
    val discountedDevices = for ((name, price) <- devices) yield (name, price * 0.9)
    println("devices: " + devices)
    println("discountedDevices: " + discountedDevices)
  }

  private def _2_count_words_using_scala_mutable_Map: Unit = {
    val in = new java.util.Scanner(new java.io.File("src/chapter4_map_n_tuple/article.txt"))
    val counter = scala.collection.mutable.Map[String, Int]()
    while (in.hasNext) {
      val word = in.next()
      counter(word) = counter.getOrElse(word, 0) + 1
    }

    println(">>> _2_count_words_using_scala_mutable_Map")
    for ((w, c) <- counter) println(w + ": " + c)
  }

  private def _3_count_words_using_scala_immutable_Map: Unit = {
    val in = new java.util.Scanner(new java.io.File("src/chapter4_map_n_tuple/article.txt"))
    var counter = Map[String, Int]()
    while (in.hasNext) {
      val word = in.next()
      counter = counter + (word -> (counter.getOrElse(word, 0) + 1))
    }

    println(">>> _3_count_words_using_scala_immutable_Map")
    for ((w, c) <- counter) println(w + ": " + c)
  }

  private def _4_count_words_using_scala_SortedMap: Unit = {
    val in = new java.util.Scanner(new java.io.File("src/chapter4_map_n_tuple/article.txt"))
    var counter = scala.collection.immutable.SortedMap[String, Int]()
    while (in.hasNext) {
      val word = in.next
      counter = counter + (word -> (counter.getOrElse(word, 0) + 1))
    }

    println(">>> _4_count_words_using_scala_SortedMap")
    for ((w, c) <- counter) println(w + ": " + c)
  }

  private def _5_count_words_using_java_TreeMap: Unit = {
    val in = new java.util.Scanner(new java.io.File("src/chapter4_map_n_tuple/article.txt"))
    val counter = new java.util.TreeMap[String, Int]()
    while (in.hasNext) {
      val word = in.next
      counter(word) = (counter.getOrElse(word, 0) + 1)
    }

    println(">>> _5_count_words_using_java_TreeMap")
    for ((w, c) <- counter) println(w + ": " + c)
  }
  
  private def _6_store_weekday_using_scala_LinkedHashMap: Unit = {
    val weekdays = scala.collection.mutable.LinkedHashMap(
      "Monday"    -> java.util.Calendar.MONDAY,
      "Tuesday"   -> java.util.Calendar.TUESDAY,
      "Wednesday" -> java.util.Calendar.WEDNESDAY,
      "Thursday"  -> java.util.Calendar.THURSDAY,
      "Friday"    -> java.util.Calendar.FRIDAY,
      "Saturday"  -> java.util.Calendar.SATURDAY,
      "Sunday"    -> java.util.Calendar.SUNDAY
    )

    val entries = scala.collection.mutable.ArrayBuffer[(String, Int)]()
    for ((k, v) <- weekdays) entries.+=((k, v))
    println(">>> _6_store_weekday_using_scala_LinkedHashMap")
    for (i <- 0 until entries.length) println(i + ": " + entries(i))
  }

  private def _7_print_system_properties: Unit = {
    val sysProps = System.getProperties
    var maxLength = 0
    sysProps.foreach {
      pair => if (pair._1.length > maxLength) maxLength = pair._1.length
    }

    val format = "%-" + maxLength + "s | %s%n"
    println(">>> _7_print_system_properties")
    sysProps.foreach {
      pair => printf(format, pair._1, pair._2)
    }
  }

  private def _8_minmax(values: Array[Int]) = (values.min, values.max)

  private def _9_lteqgt(values: Array[Int], v: Int) = (values.count(_ < v), values.count(_ == v), values.count(_ > v))

  private def _10_zip_string(): Unit = {
    println("Hello".zip("World"))
  }

}
