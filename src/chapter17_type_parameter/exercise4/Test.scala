package chapter17_type_parameter.exercise4

object Test {

  class Pair[T](val first: T, val second: T) {
    def replaceFirst(newFirst: T) = new Pair(newFirst, second)
  }
  
  class Person(name: String)
  class Student(name: String, grade: Int) extends Person(name)
  
  val p = new Pair(new Person("Xiaoming"), new Student("Laowang", 11))
  
  // parameter is invariant thus no need to add lower-bound
  p.replaceFirst(new Student("Xiaotou", 11))
  
}