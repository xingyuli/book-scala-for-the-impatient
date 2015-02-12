package chapter18_advanced_type.exercise4

import scala.collection.mutable.ArrayBuffer

object Test extends App {

  class Network {

    private val members = new ArrayBuffer[Member]

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]
      override def equals(obj: Any) = obj match {
        case that: Member => name equals that.name
        case _ => false
      }
    }

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }

  }
  
  val chatter = new Network
  val myFace = new Network
  
  val fred = chatter join "Fred"
  val fred2 = chatter join "Fred"
  val jim = chatter join "Jim"
  val barney = myFace join "Barney"
  
  println("fred equals barney: " + fred.equals(barney))
  println("fred equals jim: " + fred.equals(jim))
  println("fred equals fred2: " + fred.equals(fred2))
  
}