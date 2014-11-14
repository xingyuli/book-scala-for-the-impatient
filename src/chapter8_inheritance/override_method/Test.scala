package chapter8_inheritance.override_method

object Test extends App {
  val p = new Employee
  if (p.isInstanceOf[Employee]) {
    val s = p.asInstanceOf[Employee]
  }
}

class Person {
  var name: String = _
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary: Double = _
  override def toString = super.toString + "[salary=" + salary + "]"
}