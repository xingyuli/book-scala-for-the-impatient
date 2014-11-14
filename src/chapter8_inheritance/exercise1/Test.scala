package chapter8_inheritance.exercise1

object Test {

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }
  
  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    override def deposit(amount: Double) = super.deposit(amount - 1)
    override def withdraw(amout: Double) = super.withdraw(amout + 1)
  }
  
}