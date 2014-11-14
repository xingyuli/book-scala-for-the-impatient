package chapter8_inheritance.exercise9

object Test extends App {

  class Creature {
    def range = 10
    val env = new Array[Int](range)
  }

  class Ant extends { override val range = 2 } with Creature

  println(new Ant().env.length)

}