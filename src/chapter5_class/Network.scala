package chapter5_class

import scala.collection.mutable.ArrayBuffer

class Network {

  class Member(name: String) {
    val contacts = new ArrayBuffer[Member]
  }
  
  private val members = new ArrayBuffer[Member]
  
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
  
}

class GeneralNetwork {

  class Member(name: String) {
    val contacts = new ArrayBuffer[GeneralNetwork#Member]
  }
  
  private val members = new ArrayBuffer[Member]
  
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
  
}

object NetworkTest {

  def main(args: Array[String]) {
    val chatter = new Network
    val myFace = new Network
    
    val fred = chatter.join("Fred") // produces: chatter.Member
    val wilma = chatter.join("Wilma") // produces: chatter.Member
    fred.contacts += wilma

    val barney = myFace.join("Barney") // produces: myFace.member
    // chatter.Member required but is myFace.Member
    // fred.contacts.+=(barney)
    
    val generalNetworkA = new GeneralNetwork
    val generalNetworkB = new GeneralNetwork
    val albert = generalNetworkA.join("Albert") // produces: generalNetworkA.Member
    val jessy = generalNetworkB.join("Jessy") // produces: generalNetworkB.Member
    // as the contacts is declared as
    //     ArrayBuffer[GeneralNetwork#Member]
    // it is possible to put in any Member created by any GeneralNetwork
    // instance
    albert.contacts += jessy
    jessy.contacts += albert
  }
  
}