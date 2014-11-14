package chapter8_inheritance.exercise6

object Test {

  abstract class Shape {
    def centerPoint: (Double, Double)
  }
  
  class Rectangle(w: Double, h: Double) extends Shape {
    def centerPoint = (0.0, 0.0)
  }
  
  class Circle(r: Double) extends Shape {
    def centerPoint = (0.0, 0.0)
  }
  
}