package chapter15_annotation.exercise8

object Test {

  def allDifferent[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z
  
}