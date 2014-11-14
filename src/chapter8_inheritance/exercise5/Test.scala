package chapter8_inheritance.exercise5

object Test extends App {

  class Point(x: Double, y: Double)
  
  class LabeledPoint(val label: String, val x: Double, val y: Double) extends Point(x, y) 
  
  val p = new LabeledPoint("Black Thurday", 1929, 230.07)
  printf("%s[ x=%s, y=%s ]%n", p.label, p.x, p.y)
  
}