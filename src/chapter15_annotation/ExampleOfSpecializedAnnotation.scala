package chapter15_annotation

object ExampleOfSpecializedAnnotation extends App {

  // specialize for all primitive types including Scala Unit type
  def allDifferent[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z
  
  // only specialize for Long and Double 
  def allDifferent1[@specialized(Long, Double) T](x: T, y: T, z: T) = x != y && x != z && y != z
  
  println(allDifferent(3, 4, 5))
  
}