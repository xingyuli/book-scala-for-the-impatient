package chapter18_advanced_type

object ExampleOfDependencyInjection extends App {

  trait LoggerComponent {
    trait Logger {
      def log(msg: String)
    }
    
    val logger: Logger
    
    class ConsoleLogger extends Logger {
      override def log(msg: String) {
        println("[ConsoleLogger] " + msg)
      }
    }
  }

  trait AuthComponent {
    this: LoggerComponent => // ability to access Logger
      
      trait Auth {
        def login(id: String, password: String): Boolean
      }

      val auth: Auth
      
      class MockAuth extends Auth {
        override def login(id: String, password: String) = {
          println("Login with id=" + id + ", password=" + password)
          true
        }
      }
  }
  
  object AppComponents extends AuthComponent with LoggerComponent {
    val logger = new ConsoleLogger
    val auth = new MockAuth
  }
  
  if(AppComponents.auth.login("xiaoming", "123456")) {
    AppComponents.logger.log("Login succeeded!")
  }
  
}