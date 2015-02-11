package chapter14_pattern_match_n_case_class.exercise8

object Test extends App {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(op: Char, trees: BinaryTree*) extends BinaryTree
  
  def eval(tree: BinaryTree): Int = tree match {
    case Leaf(v) => v
    case Node('+', t) => eval(t)
    case Node('-', t) => -eval(t)
    case Node('*', t) => eval(t)
    case Node('/', t) => 1 / eval(t)
    case Node(op, ts @ _*) => ts.map(eval _).reduceLeft{ (x, y) =>
        op match {
          case '+' => x + y
          case '-' => x - y
          case '*' => x * y
          case '/' => x / y
        }
      }
  }
  
  val n1 = Node('*', Leaf(3), Leaf(8))
  val n2 = Leaf(2)
  val n3 = Node('-', Leaf(5))
  val t = Node('+', n1, n2, n3)

  println(eval(t))
  
}