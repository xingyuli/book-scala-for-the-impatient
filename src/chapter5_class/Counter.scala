package chapter5_class

class Counter {

  private var value = 0
  
  // the access modifies default to public
  def increment() { value += 1 }
  
  // if declare the method with
  //   def current = value
  // then it will force the user to use the form of counter.current
  def current = value
  
  def isLess(other: Counter) = value < other.value
  
}

object CounterTest {
  
  def main(args: Array[String]) {
    val myCounter = new Counter
    // the () is optional when invoking method without parameters
    myCounter.increment()
    println(myCounter.current)
  }
  
}