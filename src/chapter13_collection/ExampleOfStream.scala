package chapter13_collection

object ExampleOfStream {

  def numsFrom(n: Int): Stream[Int] = n #:: numsFrom(n+1)
  
  def main(args: Array[String]) {
    val tenOrMore = numsFrom(10)

    // Stream(10, ?)
    println(tenOrMore)
    
    // Stream(13, ?)
    println(tenOrMore.tail.tail.tail)
    
    val squares = numsFrom(1).map { x => println("invoke: " + x); x * x }
    // Stream(1, ?)
    // and squares(1) is cached
    println(squares)
    // Stream(1, 4, 9, 16, 25
    // and square(2), square(3), square(4), square(5) are cached
    println(squares.take(5).force)
    
    println(squares(3))
  }
  
}