package chapter18_advanced_type

object Title

class Document {
  private var useNextArgAs: Any = null
  private[chapter18_advanced_type] var title = ""

  def set(obj: Title.type): this.type = { useNextArgAs = obj; this }
  def to(arg: String) = {
    if (useNextArgAs == Title) title = arg;
  }
}

class Book extends Document

object FluentAPIBasedOnSingletonType extends App {
  
  val book = new Book
  // book.set(Title).to("Scala for the impatient")
  book set Title to "Scala for the impatient"
  
  println(book.title)
  
}