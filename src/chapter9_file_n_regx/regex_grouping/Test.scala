package chapter9_file_n_regx.regex_grouping

object Test {

  def main(args: Array[String]) {
    val numitemPattern = "([0-9]+) ([a-z]+)".r
    val numitemPattern(num, item) = "99 bottles"
    println("num: " + num + ", item: " + item)
    
    for (numitemPattern(num, item) <- numitemPattern.findAllIn("99 bottles, 98 bottles")) {
      println("num: " + num + ", item: " + item)
    }
  }
  
}