package chapter18_advanced_type.exercise6

import scala.math._
import scala.util.Either

object Test extends App {

  def indexOf(arr: Array[Int], value: Int): Int Either Int = {
    var delta = Int.MaxValue
    var found = 0
    
    for (i <- (0 until arr.length)) {
      if (abs(arr(i) - value) < delta) {
        delta = abs(arr(i) - value)
        found = i
      }
      
      if (delta == 0) {
        return Right(found)
      }
    }
    
    Left(found)
  }
  
  println(indexOf(Array(1, 2, 3, 4, 5), 3))
  println(indexOf(Array(1, 3, 5, 8, 12), 6))
  
}