package chapter13_collection.exercise2

object Test {

  def indexes(s: String) = (Map[Char, Seq[Int]]() /: s.zipWithIndex) {
    (m, p) => m + (p._1 -> (m.getOrElse(p._1, List[Int]()) :+ p._2))
  }
  
  def main(args: Array[String]) {
    println(indexes("Mississippi"))
  }
  
}