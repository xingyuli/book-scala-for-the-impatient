package chapter4_map_n_tuple

object TupleDemo {

  def main(args: Array[String]) {
    simpleUsage
    zipDemo
  }
  
  private def simpleUsage: Unit = {
    val t = (1, 3.14, "Fred")
    
    println(t)
    
    println(t._1 + ", " +  t._2 + ", " + (t _3))
    
    val (first, second, third) = t
    println("first: " + first)
    println("second: " + second)
    println("third: " + third)
    
    // use _ to discard element
    val (a, b, _) = t
    println("a = " + a + ", b = " + b)
    
    // String#partition use tuple to return multiple values
    println("Hello World".partition(_.isUpper))
  }
  
  private def zipDemo: Unit = {
    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    println("symbols: " + symbols.mkString(", "))
    println("counts: " + counts.mkString(", "))
    
    val pairs = symbols zip counts
    for ((s, n) <- pairs) Console.print(s * n)
    println()
    
    println(symbols.zip(counts).toMap)
  }
  
}