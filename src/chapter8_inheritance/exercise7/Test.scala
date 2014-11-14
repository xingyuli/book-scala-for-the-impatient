package chapter8_inheritance.exercise7

object Test {

  class Square(corner: (Int, Int), width: Int)
      extends java.awt.Rectangle(corner._1, corner._2, width, width) {
    
    def this(width: Int) {
      this((0, 0), width)
    }
    
    def this() {
      this((0, 0), 0)
    }
    
  }
  
}