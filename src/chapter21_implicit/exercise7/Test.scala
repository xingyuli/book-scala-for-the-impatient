package chapter21_implicit.exercise7

import java.awt.Point

object Test extends App {
  def compare[T](a: T, b: T)(implicit ord: Ordering[T]): Int = ord.compare(a, b)
  
  implicit object PointOrdering extends Ordering[Point] {
    def compare(x: Point, y: Point): Int = {
      if (x.x != y.x) x.x - y.x
      else x.y - y.y
    }
  }
  
  println(compare(new Point(2, 4), new Point(2, 5)))
}