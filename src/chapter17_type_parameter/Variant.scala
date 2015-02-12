package chapter17_type_parameter

object Variant {

  class Person(name: String)
  class Student(name: String, grade: Int) extends Person(name)
  
  class Pair[+T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair(newFirst, second)
  }
  
  def makeFriends(p: Pair[Person]) {
  }
  
  val p = new Pair(new Student("Xiaoming", 2), new Student("Laowang", 11))
  makeFriends(p)
  
}