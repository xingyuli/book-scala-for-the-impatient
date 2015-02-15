package chapter18_advanced_type.exercise8

object Test extends App {

  def printValues(f: (Int) => Int, from: Int, to: Int) {
    from.to(to).foreach { x => print(f(x) + " ") }
    println
  }
  
  printValues((x: Int) => x * x, 3, 6)
  printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6)
  
}