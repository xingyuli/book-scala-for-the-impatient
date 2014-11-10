package chapter4_map_n_tuple

object Sorted {

  def main(args: Array[String]) {
    // Scala 2.9 has no mutable tree map.
    val scores = scala.collection.immutable.SortedMap(
        "Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
    println(scores)
    
    val lm = scala.collection.mutable.LinkedHashMap(
        "Jan" -> 1, "Feb" -> 2, "Mar" -> 3,
        "Apr" -> 4, "May" -> 5, "Jun" -> 6,
        "Jul" -> 7, "Aug" -> 8, "Sep" -> 9,
        "Oct" -> 10, "Nov" -> 11, "Dec" -> 12)
    println(lm)
  }

}