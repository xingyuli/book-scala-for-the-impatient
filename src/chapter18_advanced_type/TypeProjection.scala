package chapter18_advanced_type

import scala.collection.mutable.ArrayBuffer

class Network {
  
  private val members = new ArrayBuffer[Member]
  
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member]
  }
  
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
  
}

object TypeProjection extends App {

  val chatter = new Network
  val myFace = new Network
  
  val fred = chatter join "Fred" // has type chatter.Member
  val barney = myFace join "Barney" // has type myFace.Member

  // OK!
  // as we use Network#Member as the type parameter of contacts
  fred.contacts += barney
}