package chapter10_trait.with_implementation

object Test {

  trait ConsoleLogger {
    def log(msg: String) { println(msg) }
  }
  
  class SavingsAccount extends ConsoleLogger {
    
    var balance :Double = 0
    
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }

}