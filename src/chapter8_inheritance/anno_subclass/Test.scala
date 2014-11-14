package chapter8_inheritance.anno_subclass

object Test {

  def main(args: Array[String]) {
    val alien = new Person("Fred") {
      def greeting = "Greetings, Earthing! My name is Fred."
    }
    println(alien.greeting)
    
    meet(new Person("abc") {
      def run = "I can run!"
    })
  }

  def meet(p: Person{ def run: String }) {    
    println(p.name + " says: " + p.run)
  }
  
  class Person(var name: String)
  
}
