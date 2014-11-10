package chapter5_class

import scala.beans.BeanProperty

class Person {

  /*
   * default getter: age
   * default setter: age_=
   */
  // var age = 0

  // override default getter and setter
  private var privateAge = 0
  
  @BeanProperty var name: String = _
  
  def age = privateAge
  
  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue
  }
  
}

object PersonTest {
  
  def main(args: Array[String]) {
    val p = new Person
    p.age = 24
    println(p.age)
    
    p.age = 13
    println(p.age)
    
    p.age = 27
    println(p.age)
  }
  
}