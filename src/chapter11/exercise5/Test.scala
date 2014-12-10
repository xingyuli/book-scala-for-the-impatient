package chapter11.exercise5

import scala.collection.mutable.ArrayBuffer

object Test {

  class Table {

    private val t: ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer[ArrayBuffer[String]]()
    private var rowIndex = 0
    
    def |(text: String) = {
      currentRow += text
      this
    }
    
    def ||(text: String) = {
      rowIndex += 1
      |(text)
    }
    
    private def currentRow = {
      var row = if (t.size <= rowIndex) null else t(rowIndex)
      if (row == null) {
        row = new ArrayBuffer[String]()
        t += row
      }
      row
    }
    
    override def toString() = {
      var str = "<table>"
      t.foreach { row =>
        str += "<tr>"
        row.foreach(cell => str += "<td>" + cell + "</td>")
        str += "</tr>"
      }
      str + "</table>"
    }
    
  }
  
  object Table {
    def apply() = new Table()
  }
  
  def main(args: Array[String]) {
    println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET")
  }
  
}