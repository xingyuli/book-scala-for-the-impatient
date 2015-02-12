package chapter14_pattern_match_n_case_class

object VariableInPatternMatch {

  def main(args: Array[String]) {
    var sign = 0
    var digit = 0

    val s = "1+2-3"
    
    // variable
    s(3) match {
      case '+' => sign = 1
      case '-' => sign = -1
      case ch => digit = Character.digit(ch, 10)
    }
    
    // variable in guard
    s(4) match {
      case '+' => sign = 1
      case '-' => sign = -1
      case ch if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    }
    
    println("sign: " + sign + ", digit: " + digit)
  }
  
}