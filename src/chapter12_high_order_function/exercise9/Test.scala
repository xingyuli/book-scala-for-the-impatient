package chapter12_high_order_function.exercise9

object Test {

  def correspondsWithoutCurry[A, B](self: Seq[A], that: Seq[B], fun: (A, B) => Boolean): Boolean = {
    val i = self.iterator
    val j = that.iterator
    while (i.hasNext && j.hasNext) {
      if (!fun(i.next, j.next)) return false
    }
    
    !i.hasNext && !j.hasNext
  }
  
  def correspondsWithCurry[A, B](self: Seq[A])(that: Seq[B])(fun: (A, B) => Boolean): Boolean = {
    val i = self.iterator
    val j = that.iterator
    while (i.hasNext && j.hasNext) {
      if (!fun(i.next, j.next)) return false
    }
    
    !i.hasNext && !j.hasNext
  }
  
  def main(args: Array[String]) {
    val words = "My name is God Bless".split(" ")
    val counts = Array(2, 4, 2, 3, 5)
    
    // problem we met: must explicitly specify type information
    println(correspondsWithoutCurry(words, counts, (x: String, y: Int) => x.length == y))
    
    // Nice job! Curry provide more type information to the compiler! 
    println(correspondsWithCurry(words)(counts)(_.length == _))
  }
  
}