package chapter15_annotation

object TailRecursion extends App {

  def sum(xs: Seq[Int]): BigInt = {
    if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
  }
  
  // trigger Scala's Tail Recursion optimization
  def sum1(xs: Seq[Int], partial: BigInt): BigInt = {
    if (xs.isEmpty) partial else sum1(xs.tail, xs.head +partial)
  }
  
  // will produce StackOverflowError
  // println(sum(1 to 1000000))
  
  // give result: 500000500000
  println(sum1(1 to 1000000, 0))
  
}