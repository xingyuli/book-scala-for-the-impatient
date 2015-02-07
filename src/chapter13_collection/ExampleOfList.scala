package chapter13_collection

object ExampleOfList {

  def main(args: Array[String]) {
    val digits = List(4, 2)
    println("head: " + digits.head)
    println("tail: " + digits.tail)
    
    println(digits.tail.head)
    println(digits.tail.tail)
    
    println(9 :: List(4, 2))
    // 9 :: (4 :: (2 :: Nil))
    println(9 :: 4 :: 2 :: Nil)
  }
  
  def sum(lst: List[Int]): Int = {
    if (lst == Nil) 0
    else lst.head + sum(lst.tail)
  }
  
  def sum1(lst: List[Int]): Int = lst match {
    case Nil => 0
    case h :: t => h + sum(t)
  }
  
}