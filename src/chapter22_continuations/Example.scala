package chapter22_continuations

import scala.util.continuations._

object Example extends App {

  var cont: (Unit => Unit) = null

  reset {
    println("Before shift")
    shift { k: (Unit => Unit) =>
      cont = k
      println("Inside shift")
    }
    println("After shift")
  }

  println("After reset")
  cont()
  
  val result = reset {
    shift { k: (String => String) => "Exit" }
    "End"
  }
  println(result)

  val result1 = reset {
    if (false) shift { k: (String => String) => "Exit" }
    else "End"
  }
  println(result1)
  
}