package chapter10_trait.field_in_trait

object TestAbstract {

  trait Logged {
    def log(msg: String) { }
  }
  
  trait ConsoleLogger extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }
  
  trait ShortLogger extends Logged {
    val maxLength: Int // abstract field
    override def log(msg: String) {
      super.log(if (msg.length <= maxLength ) msg else msg.substring(0, maxLength  - 3) + "...")
    }
  }
  
  class Account {
    var balance = 0.0
  }

  class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
    val maxLength = 10
    var interest = 0.0
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }
  
  def main(args: Array[String]) {
    val acct = new SavingsAccount
    acct.withdraw(10000)
  }
  
}