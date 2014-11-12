package chapter6_object

object Accounts {

  private var lastNumber = 0
  
  def newUniqueNumber() = { lastNumber += 1; lastNumber }
  
}

object AccountsTest {

  def main(args: Array[String]) {
    println("result of newUniqueMember: " + Accounts.newUniqueNumber())
  }

}