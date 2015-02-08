package chapter13_collection.exercise6

object Test {

  def main(args: Array[String]) {
    val lst = List(1, 3, 5, 7)
    // original
    println( (lst :\ List[Int]())(_ +: _) )
    println( (List[Int]() /: lst)(_ :+ _) )

    // inverse
    println( (lst :\ List[Int]())((x, l) => l :+ x) )
    println( (List[Int]() /: lst)((l, x) => x +: l) )
  }
  
}