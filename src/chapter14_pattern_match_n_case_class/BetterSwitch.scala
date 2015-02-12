package chapter14_pattern_match_n_case_class

object BetterSwitch {

  def main(args: Array[String]) {
    println("matchInCStyle sign: " + matchInCStyle)
    println("simplifiedMatch sign: " + simplifiedMatch)
  }
  
  private def matchInCStyle() = {
    var sign = 0
    val ch = '-'
    
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ => sign = 0
    }
    sign
  }
  
  private def simplifiedMatch = {
    var sign = 0
    val ch = '-'

    // match is an expression
    sign = ch match {
      case '+' => 1
      case '-' => -1
      case _ => 0
    }
    sign
  }
  
}