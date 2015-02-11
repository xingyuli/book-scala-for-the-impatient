package chapter14_pattern_match_n_case_class.exercise7

object Test extends App {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(trees: BinaryTree*) extends BinaryTree
  
  def leafSum(tree: BinaryTree): Int = tree match {
    case Leaf(v) => v
    case Node(ts @ _*) => ts.map(leafSum _).sum
  }
  
  val n1 = Node(Leaf(3), Leaf(8))
  val n2 = Leaf(2)
  val n3 = Node(Leaf(5))
  val t = Node(n1, n2, n3)

  println(leafSum(t))
  
}