package chapter21_implicit.exercise3

import scala.annotation.tailrec

class RichInt(val v: Int) {
  def ! : Int = {
    @tailrec def factorial(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else factorial(acc * n, n - 1)
    }
    factorial(1, v)
  }
}

object RichInt {
  implicit def int2RichInt(n: Int) = new RichInt(n)
}