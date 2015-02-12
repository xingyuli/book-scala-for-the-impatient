package chapter18_advanced_type

object SelfType {

  trait Logged {
    def log(msg: String)
  }
  
  // use self type
  trait LoggedException extends Logged {
    this: Exception =>
      def log() { log(getMessage) }
  }
  
  trait ManagedException extends LoggedException {
    this: Exception =>
  }
  
}