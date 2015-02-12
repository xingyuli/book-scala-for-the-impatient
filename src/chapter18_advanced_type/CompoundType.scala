package chapter18_advanced_type

import java.awt.Shape
import java.awt.Point

object CompoundType extends App {

  // compound type at top level
  trait ImageShape extends Shape with Serializable
  
  def method(s: ImageShape) {}
  
  // compound type at function level
  def method2(s: Shape with Serializable) {}
  
  // use structured type together with compound type
  def method3(s: Shape with Serializable { def contains(p: Point): Boolean }) {}
  
}