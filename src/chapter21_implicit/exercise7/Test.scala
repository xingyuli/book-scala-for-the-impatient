package chapter21_implicit.exercise7

import java.awt.Point

object PointOrderings {
  
  implicit object AlphabeticalOrdering extends Ordering[Point] {
    override def compare(x: Point, y: Point): Int = {
      if (x.x != y.x) x.x - y.x
      else x.y - y.y
    }
  }
  
  implicit object DistanceOrdering extends Ordering[Point] {
    override def compare(x: Point, y: Point): Int = {
      def distance(p: Point) = p.x*p.x + p.y*p.y
      distance(x) - distance(y)
    }
  }
  
}

object Test extends App {
  
  def compare[T](a: T, b: T)(implicit ord: Ordering[T]): Int = ord.compare(a, b)
  
  {
    import PointOrderings.AlphabeticalOrdering
    println(compare(new Point(2, 5), new Point(3, 4)))
  }
  
  {
    import PointOrderings.DistanceOrdering
    println(compare(new Point(2, 5), new Point(3, 4)))
  }
  
}