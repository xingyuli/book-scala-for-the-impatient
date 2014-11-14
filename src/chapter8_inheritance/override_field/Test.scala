package chapter8_inheritance.override_field

object Test extends App {

}

class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}