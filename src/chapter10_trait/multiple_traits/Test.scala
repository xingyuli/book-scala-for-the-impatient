package chapter10_trait.multiple_traits

object Test {

  trait Logged {
    def log(msg: String) {}
  }
  
  trait ConsoleLogger extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }
  
  trait TimestampLogger extends Logged {
    override def log(msg: String) {
      super.log(new java.util.Date + " " + msg)
    }
  }
  
  trait ShortLogger extends Logged {
    val maxLength = 15
    override def log(msg: String) {
      super.log(if (msg.length <= maxLength ) msg else msg.substring(0, maxLength  - 3) + "...")
    }
  }
  
  class SavingsAccount extends Logged {
    
    var balance :Double = 0
    
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }
  
  def main(args: Array[String]) {
    val acct1 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger
    val acct2 = new SavingsAccount with ConsoleLogger with ShortLogger with TimestampLogger
    acct1.withdraw(10)
    acct2.withdraw(20)
  }
  
}