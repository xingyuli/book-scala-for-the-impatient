package chapter9_file_n_regx.regex_basic

object Test {

  def main(args: Array[String]) {
    val text = "99 bottles, 98 bottles"
    
    val numPattern = "[0-9]+".r
    for (matchString <- numPattern findAllIn text) {
      println(matchString)
    }
    println(numPattern findPrefixOf text)
    println(numPattern replaceFirstIn (text, "XX"))
    println(numPattern replaceAllIn (text, "XX"))
    
    val wsnumsPattern = """\s+[0-9]+\s+""".r
    for (matchString <- wsnumsPattern findAllIn text) {
      println(matchString)
    }
    println(wsnumsPattern findPrefixOf text)
  }
  
}