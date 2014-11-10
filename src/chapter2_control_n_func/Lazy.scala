package chapter2_control_n_func

object Lazy {

  def main(args: Array[String]) {
    lazy val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString
    try {
      println(words)
    } catch {
      case _: Exception => println("expression be evaluated when first access lazy variable")
    }
  }

}
