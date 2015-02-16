package chapter20_actor

import scala.actors.Actor
import scala.actors.Actor._

object Example1OfInitAndStartAnActor extends App {

  class HiActor extends Actor {
    def act() {
      while (true) {
        receive {
          case "Hi" => println("Hello")
        }
      }
    }
  }
  
  val actor1 = new HiActor
  actor1.start()
  
  // alternative to use an anonymous actor
  val actor2 = actor {
    while (true) {
      receive {
        case "Hi" => println("Hello")
      }
    }
  }
  
}