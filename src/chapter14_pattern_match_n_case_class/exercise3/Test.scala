package chapter14_pattern_match_n_case_class.exercise3

object Test extends App {

  def swapArray[E](arr: Array[E]) = arr match {
    case Array(first, second, rest @ _*) if arr.length >= 2 => Array(second, first, rest)
  }
  
  def swapList[E](lst: List[E]) = lst match {
    case first :: second :: tail if lst.size >= 2 => second :: first :: tail
  }
  
  for (el <- swapArray(Array(1, 2, 3, 4, 5))) print(el + " ")
  
  println
  println(swapList(List(1, 2, 3, 4, 5)))
  
}