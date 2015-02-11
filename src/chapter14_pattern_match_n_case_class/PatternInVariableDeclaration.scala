package chapter14_pattern_match_n_case_class

object PatternInVariableDeclaration {

  def main(args: Array[String]): Unit = {
    val (x, y) = (1, 2)
    println("x: " + x + ", y: " + y)
    
    val (q, r) = BigInt(10) /% 3
    println("q: " + q + ", r: " + r)
  }
  
}