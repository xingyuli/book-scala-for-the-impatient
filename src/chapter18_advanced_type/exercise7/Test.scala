package chapter18_advanced_type.exercise7

object Test extends App {

  def invoke[T](target: T { def close(): Unit }, op: (T) => Unit) {
    try {
      op(target)
    } finally {
      target.close()
    }
  }
  
  class Window {
    def close() { println("window was closed") }
  }
  
  invoke(new Window, (_: Window) => { println("open the window") })
  
}