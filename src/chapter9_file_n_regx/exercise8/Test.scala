package chapter9_file_n_regx.exercise8

object Test {

  def main(args: Array[String]) {
    val html = """<img src="//www.baidu.com/img/bdlogo.png" height="129" width="270"/>"""

    val imgSrcPattern = """<img.*src="(\S*)".*/>""".r
    for (imgSrcPattern(src) <- imgSrcPattern findAllIn html) {
      println(src)
    }
  }
  
}