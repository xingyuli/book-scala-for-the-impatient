package chapter8_inheritance.abstract_class

object Test extends App {
  
  abstract class Person(val name: String) {
    def id: Int // no method body - this is an abstract method
  }
  
  class Employee(name: String) extends Person(name) {
    def id = name.hashCode // override is not needed
  }
  
  val e = new Employee("God")
  println("The id of " + e.name + " is " + e.id + ".")
  
}