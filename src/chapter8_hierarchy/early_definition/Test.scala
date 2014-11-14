package chapter8_hierarchy.early_definition

object Test extends App {

  class Creature {
    val range = 10
    val env = new Array[Int](range)
  }
  
  class Ant extends Creature {
    override val range = 2
  }
  
  // Unexpected, will print 0!
  println(new Ant().env.length)
  
  class Ant2 extends { override val range = 2 } with Creature
  
  // Well, this prints 2.
  println(new Ant2().env.length)
  
}