package chapter12_high_order_function.exercise1

object Test {

  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for(i <- (low to high)) yield (i, fun(i))
  }
  
  def main(args: Array[String]) {
    println(values(x => x*x, -5, 5))
  }
  
}