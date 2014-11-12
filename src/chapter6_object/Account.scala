package chapter6_object

class Account private (val id: Int, initialBalance: Double) {

  private var balance = initialBalance
  
  def deposit(amount: Double) { balance += amount }
  
  def withdraw(amount: Double) { balance -= amount }
  
}

object Account { // companion object

  private var lastNumber = 0
  private def newUniqueMember() = { lastNumber += 1; lastNumber }

  def apply(initialBalance: Double) = {
    new Account(newUniqueMember, initialBalance)
  }

}

object AccountTest {

  def main(args: Array[String]) {
    // apply invoked
    val acct = Account(1000.0)
  }

}