package chapter5_class

import scala.beans.BeanProperty

object Exercise {

  def main(args: Array[String]) {
    val counter = new _1_Counter(Int.MaxValue)
    println(counter.current)
    counter.increment()
    println(counter.current)
    
    val bankAccount = new _2_BankAccount
    bankAccount deposit 1000
    bankAccount withdraw 200
    println(bankAccount.balance)
    
    val timeA = new _3_Time(23, 12)
    val timeB = new _3_Time(20, 8)
    println(timeA before timeB)
    println(timeB before timeA)
    
    val timeC = new _4_Time(23, 12)
    val timeD = new _4_Time(20, 8)
    println(timeC before timeD)
    println(timeD before timeC)
    
    val student = new _5_Student("God", -1)
    
    val personA = new _6_Person(-12)
    val personB = new _6_Person(24)
    println("personA: " + personA.age)
    println("personB: " + personB.age)
    
    val personC = new _7_Person("Fred Smith")
    println("First name: " + personC.firstname)
    println("Last name: " + personC.lastname)
    
    val car = new _8_Car("TestName", "TestSerial", 2014, "AB1234")
    printf("vendor: %s, serial: %s, createdAt: %s, No.: %s%n",
        car.vendor, car.serial, car.createdAt, car.no)
    car.no = "CD9999"
    println("Now, the No. has been changed to " + car.no)
  }
  
}

class _1_Counter(start: Int) {
  
  private var value = scala.math.BigInt(start)
  
  def increment() { value += 1 }
  
  def current = value
  
}

class _2_BankAccount {

  private var privateBalance = 0
  
  def deposit(n: Int) {
    privateBalance += n
  }
  
  def withdraw(n: Int) {
    privateBalance -= n
  }
  
  def balance = privateBalance

}

class _3_Time {

  private var hrs = 0
  private var min = 0
  
  def this(hrs: Int, min: Int) {
    this()
    if (hrs < 0 || hrs > 23) throw new IllegalArgumentException("hrs")
    this.hrs = hrs
    this.min = min
  }
  
  def hours = hrs
  def minutes = min
  
  def before(other: _3_Time): Boolean = hrs < other.hrs || minutes < other.minutes
  
}

class _4_Time {

  private var time = 0
  
  def this(hrs: Int, min: Int) {
    this()
    if (hrs < 0 || hrs > 23) throw new IllegalArgumentException("hrs")
    time = hrs * 60 + min
  }
  
  def hours = time / 60
  def minutes = time % 60
  
  def before(other: _4_Time): Boolean = time < other.time
  
}

class _5_Student(@BeanProperty var name: String, @BeanProperty var id: Int)

class _6_Person(agec: Int) {
  val age = if (agec < 0) 0 else agec
}

class _7_Person(fullname: String) {
  val firstname = fullname.substring(0, fullname.indexOf(" "))
  val lastname = fullname.substring(fullname.indexOf(" ") + 1)
}

class _8_Car(val vendor: String, val serial: String, val createdAt: Int = -1, var no: String = "")

class _10_Employee {
  val name: String = "John Q. Public"
  val salary: Double = 0.0
}