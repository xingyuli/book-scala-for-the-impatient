package chapter17_type_parameter

object GenericFunction extends App {

  def getMiddle[T](a: Array[T]) = a(a.length / 2)
  
  println(getMiddle(Array("Mary", "had", "a", "little", "lamb")))
  
  val f = getMiddle[String] _
}