package chapter18_advanced_type.exercise9

object Test extends App {

  abstract class Dim[T](val value: Double, val name: String) {
    this: T =>
      protected def create(v: Double): T
      def +(other: Dim[T]) = create(value + other.value)
      override def toString() = value + " " + name
  }
  
  class Seconds(v: Double) extends Dim[Seconds](v, "s") {
    override def create(v: Double) = new Seconds(v)
  }
  
  class Meters(v: Double) extends Dim[Meters](v, "m") {
    override def create(v: Double) = new Meters(v)
  }
  
  val sec = new Seconds(3)
  val meter = new Meters(3)
  
  // println(sec + meter)
  
}