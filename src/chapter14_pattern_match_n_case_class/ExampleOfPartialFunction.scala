package chapter14_pattern_match_n_case_class

object ExampleOfPartialFunction extends App {

  val f: PartialFunction[Char, Int] = { case '+' => 1; case '-' => -1 }
  
  println(f('-'))
  
  println(f.isDefinedAt('0'))
  
  // MatchError
  // println(f('0'))
  
  println("-3+4".collect { case '+' => 1; case '-' => -1 })
  
}