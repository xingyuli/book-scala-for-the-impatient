package chapter12_high_order_function.exercise8

object Test {

  def main(args: Array[String]) {
    val words = "My name is God Bless".split(" ")
    val counts = Array(2, 4, 2, 3, 5)
    
    println(words.corresponds(counts)(_.length == _))
  }
  
}