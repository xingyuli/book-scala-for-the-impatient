package chapter18_advanced_type.exercise3

object Test extends App {

  object Title
  object Author

  class Document {
    private var useNextArgAs: Any = null
    private[chapter18_advanced_type] var title = ""
    private[chapter18_advanced_type] var author = ""
  
    def set(obj: Title.type): this.type = { useNextArgAs = obj; this }
    def set(obj: Author.type): this.type = { useNextArgAs = obj; this }
    def to(arg: String): this.type = {
      useNextArgAs match {
        case Title => title = arg
        case Author => author = arg
      }
      this
    }
  }
  
  class Book extends Document
  
  val book = new Book
  book set Title to "Scala for the impatient" set Author to "Cay Horstmann"
  println("title: " + book.title + ", author: " + book.author)
  
}
