package chapter18_advanced_type

import scala.collection.mutable.ArrayBuffer

object StructuredType extends App {

  def appendLines(target: { def append(str: String): Any },
      lines: Iterable[String]) {
    for (l <- lines) {
      target.append(l); target.append("\n")
    }
  }
  
  class HtmlDivAppender {
    val builder = new ArrayBuffer[String]
    def append(str: String): this.type = {
      builder += (str match {
        case "\n" => "\n"
        case ne => "<div>" + ne + "</div>" 
      })
      this
    }
    
    override def toString = builder.mkString("")
    
  }
  
  var target = new HtmlDivAppender
  appendLines(target, Array("one", "two", "three"))
  println(target)
  
}