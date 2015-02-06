package chapter12_high_order_function

object AbstractionOfControl {

  def runInThread(block: () => Unit) {
    new Thread {
      override def run() { block() }
    }.start()
  }
  
  def runInThread1(block: => Unit) {
    new Thread {
      override def run() { block }
    }.start()
  }
  
  // call-by-name and curry
  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }
  
  def main(args: Array[String]) {
    runInThread { () =>
      println("Hi")
      Thread.sleep(5000)
      println("Bye")
    }
    
    runInThread1 { println("Hi"); Thread.sleep(5000); println("Bye"); }
    
    var x = 10
    until(x == 0) {
      x -= 1
      println(x)
    }
  }

}