package chapter10_trait.as_interface

object Test {

  trait Logger {
    def log(msg: String)
  }
  
  class ConsoleLogger extends Logger { // use extends, rather than implements
    def log(msg: String) { println(msg) } // no need to use override
  }
  
}