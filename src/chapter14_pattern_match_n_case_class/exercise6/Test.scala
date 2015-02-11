package chapter14_pattern_match_n_case_class.exercise6

object Test extends App {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
  
  def leafSum(tree: BinaryTree): Int = tree match {
    case Leaf(v) => v
    case Node(l, r) => leafSum(l) + leafSum(r)
  }
  
}