package chapter8_hierarchy.abstract_field

object Test {

  abstract class Person {
    val id: Int
        // abstract field with abstract getter
    
    var name: String
        // abstract field with abstract getter and setter
  }
  
  class Employee(val id: Int) extends Person { // subclass has concrete id
    var name = "" // and concrete name
  }
  
  // anonymous class 
  val fred = new Person {
    val id = 1729
    var name = "Fred"
  }

}