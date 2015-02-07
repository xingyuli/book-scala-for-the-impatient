package chapter13_collection

object ReduceAndFolderAndScan {

  def main(args: Array[String]) {
    exampleOfReduce()
    exampleOfFold()
    exampleOfScan()
  }

  private def exampleOfReduce() {
    // ((1 - 7) - 2) - 9
    println(List(1, 7, 2, 9).reduceLeft(_ - _))
    
    // 1 - (7 - (2 - 9))
    println(List(1, 7, 2, 9).reduceRight(_ - _))
  }
  
  private def exampleOfFold() = {
    // (((0 - 1) - 7) - 2) - 9
    println(List(1, 7, 2, 9).foldLeft(0)(_ - _))
    // equivalent of foldLeft
    println((0 /: List(1, 7, 2, 9))(_ - _))

    // 1 - (7 - (2 - (9 - 0)))
    println(List(1, 7, 2, 9).foldRight(0)(_ - _))
    // equivalent of foldRight
    println((List(1, 7, 2, 9) :\ 0)(_ - _))
    
    val freq = scala.collection.mutable.Map[Char, Int]()
    for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
    println("freq: " + freq)
    
    val freq1 = (Map[Char, Int]() /: "Mississippi") {
      (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
    }
    println("freq1: " + freq1)
  }
  
  private def exampleOfScan() {
    println((1 to 10).scanLeft(0)(_ + _))
  }

}