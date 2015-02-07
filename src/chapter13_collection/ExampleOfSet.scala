package chapter13_collection

object ExampleOfSet {

  def main(args: Array[String]) {
    println(Set(2, 0, 1) + 1)
    
    val weekdays = scala.collection.mutable.LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")
    println(weekdays)
    
    println(scala.collection.immutable.SortedSet(1, 2, 3, 4, 5, 6))
    
    val digits = Set(1, 7, 2, 9)
    println(digits contains 0)
    println(Set(1, 2) subsetOf digits)
  }

}