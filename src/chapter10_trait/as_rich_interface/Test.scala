package chapter10_trait.as_rich_interface

object Test {

  trait Logger {
    def log(msg: String)
    def info(msg: String) { log("INFO: " + msg) }
    def warn(msg: String) { log("WARN: " + msg) }
    def severe(msg: String) { log("SEVERE: " + msg) }
  }
  
  class Account(balanceC: Double) {
    var balance = balanceC
  }
  
  class SavingsAccount extends Account(0.0) with Logger {
  
    def withdraw(amount: Double) {
      if (amount > balance) severe("Insufficient funds")
      else balance -= amount
    }
    
    override def log(msg: String) {
      println(msg)
    }
  
  }
  
}