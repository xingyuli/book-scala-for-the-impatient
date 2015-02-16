package chapter20_actor

import scala.actors._
import scala.actors.OutputChannel
import scala.actors.Actor
import scala.actors.Actor._
import scala.actors.Channel

object Example3OfChannel extends App {

  case class Compute(input: Seq[Double], result: OutputChannel[Double])
  
  class Computer extends Actor {
    def act() {
      while (true) {
        receive {
          case Compute(input, out) => { val answer = input.sum; out ! answer }
        }
      }
    }
  }
  
  val readyActor = new Computer
  readyActor.start()
  
  actor {
    val channel = new Channel[Double]
    val computeActor = readyActor
    val input: Seq[Double] = List(1.0, 2.0, 3.0, 4.0)
    
    computeActor ! Compute(input, channel)
    
    // Way 1:
    // channel.receive {
    //   case x => println("Got result: " + x)
    // }
    
    // Way 2:
    // receive {
    //   case !(channel, x) => println("Got result: " + x)
    // }
    
    // Way 3:
    receive {
      case channel ! x => println("Got result: " + x)
    }
  }
  
}