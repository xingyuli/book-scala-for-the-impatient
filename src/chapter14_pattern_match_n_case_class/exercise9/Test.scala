package chapter14_pattern_match_n_case_class.exercise9

object Test extends App {

  def sum(lst: List[Option[Int]]) = lst.map(_.getOrElse(0)).sum
  
  println(sum(List(
      Some(5), Some(3), None, Some(1), None, Some(9))))
  
}