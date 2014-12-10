package chapter10_trait.field_in_trait

object Test {

  trait Logged {
    def log(msg: String) { }
  }
  
  trait ConsoleLogger extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }
  
  trait ShortLogger extends Logged {
    val maxLength = 15
    override def log(msg: String) {
      super.log(if (msg.length <= maxLength ) msg else msg.substring(0, maxLength  - 3) + "...")
    }
  }
  
  class Account {
    var balance = 0.0
  }
  
  // provided by super class:
  //   balance
  // provided by sub class:
  //   interest
  //   maxLength
  class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
    var interest = 0.0
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }
  
}