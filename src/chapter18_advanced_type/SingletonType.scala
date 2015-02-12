package chapter18_advanced_type

object ExampleOfSingletonType extends App {

  class Document {
    def setTitle(title: String): this.type = { /* ... */ this }
    def setAuthor(author: String): this.type = { /* ... */ this }
  }
  
  class Book extends Document {
    def addChapter(chapter: String): this.type = { /* ... */ this }
  }
  
  val book = new Book
  book.setTitle("Whatever Floats Your Boat").setAuthor("Cay Horstman")
    .addChapter("Chapter 1")
  
}