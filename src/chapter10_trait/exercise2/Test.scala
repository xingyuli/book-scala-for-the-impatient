package chapter10_trait.exercise2

import java.awt.Point
import scala.math.Ordered

object Test {

  class OrderedPoint extends Point with Ordered[Point] {
    
    def compare(that: Point) = {
      val comparisonOfX = this.getX compare that.getX
      if (comparisonOfX != 0) {
        comparisonOfX
      }
      this.getY compare that.getY
    }
    
  }
  
}