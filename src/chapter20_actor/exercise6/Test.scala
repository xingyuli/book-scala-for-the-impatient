package chapter20_actor.exercise6

import scala.actors.Actor._
import scala.actors.Actor
import scala.collection.mutable.ArrayBuffer

object Test extends App {

  val actors = ArrayBuffer[Actor]()
  for (i <- 0 until 10) {
    actors += actor {
      while (true) {
        receive {
          case "Hello" =>
            println(Thread.currentThread)
            
            val innerActors = ArrayBuffer[Actor]()
            for (i <- 0 until 10) {
              innerActors += actor {
                loop {
                  react {
                    case "Hello" =>
                      println("inner: " + Thread.currentThread)
                  }
                }
              }
            }
            innerActors.foreach { _ ! "Hello" }
        }
      }
    }
  }
  
  actors.foreach { _ ! "Hello" }
  
}