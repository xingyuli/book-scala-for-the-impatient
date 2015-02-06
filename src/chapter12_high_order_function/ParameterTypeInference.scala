package chapter12_high_order_function

object TypeInference {
  
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  
  def main(args: Array[String]) {
    println(valueAtOneQuarter((x: Double) => 3 * x))
    
    // no need to explicitly specify the type information
    println(valueAtOneQuarter((x) => 3 * x))
    
    // surrounding "()" could be eliminated if has only one parameter 
    println(valueAtOneQuarter(x => 3 * x))
    
    // even can be more concise like this
    println(valueAtOneQuarter(3 * _))
  }
  
}