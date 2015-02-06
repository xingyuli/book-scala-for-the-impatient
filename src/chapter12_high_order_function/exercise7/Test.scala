package chapter12_high_order_function.exercise7

object Test {

  def adjustToPair(func: (Int, Int) => Int)(pair: (Int, Int)) = {
    func(pair._1, pair._2)
  }
  
  def main(args: Array[String]) {
    val pairs = (1 to 10) zip (11 to 20)
    pairs.map(adjustToPair(_ + _)(_)).foreach(println)
  }
  
}