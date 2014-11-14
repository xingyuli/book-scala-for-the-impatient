package chapter8_inheritance.exercise2

object Test {

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }
  
  class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    
    private val free = 3
    private var transactionCount = 0
    
    override def deposit(amount: Double) = {
      transactionCount += 1
      super.deposit(if (transactionCount <= free) amount else amount - 1)
    }
    
    override def withdraw(amount: Double) = {
      transactionCount += 1
      super.withdraw(if (transactionCount <= free) amount else amount + 1)
    }
    
    def earnMonthlyInterest { transactionCount = 0 }
    
  }
  
}