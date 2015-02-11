package chapter14_pattern_match_n_case_class.exercise2

object Test extends App {

  def swap(p: (Int, Int)) = p match {
    case (k, v) => (v, k) 
  }
  
  println(swap(1, 3))
  
}