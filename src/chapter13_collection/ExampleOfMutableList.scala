package chapter13_collection

object ExampleOfMutableList {

  def main(args: Array[String]) {
    val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)

    var cur = lst
    while (cur != Nil) {
      if (cur.elem < 0) cur.elem = 0
      cur = cur.next
    }

    println(lst)
  }
  
}