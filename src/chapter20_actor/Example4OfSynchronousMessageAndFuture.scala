package chapter20_actor

import scala.actors.Actor
import scala.actors.Actor._

object Example4OfSynchronousMessageAndFuture extends App {

  private var balance = 0.0
  
  case class Deposit(value: Double)
  case class Withdraw(value: Double)
  case class Balance(value: Double)
  
  class AccountActor extends Actor {
    def act() {
      while (true) {
        receive {
          case Deposit(amount) => balance += amount; reply(Balance(balance))
          case Withdraw(amount) => balance -= amount; reply(Balance(balance))
        }
      }
    }
  }
  
  val account = new AccountActor
  account.start()
  
  actor {
    // waiting for response synchronously
    val reply = account !? Deposit(1000)
    reply match {
      case Balance(bal) => println("Current balance: " + bal)
    }
  }
  
  actor {
    val replyFuture = account !! Deposit(1000)
    
    // do something else
    
    // and we are free to retrieve the answer
    val reply = replyFuture()
    reply match {
      case Balance(bal) => println("Async balance: " + bal)
    }
  }
  
}