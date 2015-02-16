package chapter20_actor

import scala.actors.Actor

object Example2OfReceiveMessage extends App {

  private var balance = 0.0
  
  case class Deposit(value: Double)
  case class Withdraw(value: Double)
  
  class AccountActor extends Actor {
    def act() {
      while (true) {
        receive {
          case Deposit(amount) => balance += amount
          case Withdraw(amount) => balance -= amount
        }
      }
    }
  }
  
}