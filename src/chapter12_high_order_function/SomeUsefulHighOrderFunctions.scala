package chapter12_high_order_function

object SomeUsefulHighOrderFunctions {

  def main(args: Array[String]) {
    (1 to 9).map(0.1 * _).foreach(println)
    
    (1 to 9).map("*" * _).foreach(println)
    
    val a = (1 to 9).filter(_ % 2 == 0)
    println(a.mkString(","))
    
    val result = (1 to 9).reduceLeft(_ * _)
    println("(1 to 9).reduceLeft(_ * _): " + result)
    
    val words = "Mary has a little lamb".split(" ").sortWith(_.length < _.length)
    println(words.mkString(","))
  }
  
}