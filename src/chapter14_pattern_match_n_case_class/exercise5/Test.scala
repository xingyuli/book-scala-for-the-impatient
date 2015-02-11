package chapter14_pattern_match_n_case_class.exercise5

object Test extends App {

  def leafSum[E](lst: List[E]): Int = lst.map {
    _ match { 
      case x: Int => x
      case (x: Int) :: tail => x + leafSum(tail)
      case _ => 0
    }
  }.sum
  
  println(leafSum(List(
      List(3, 8), 2, List(5))))
  
}