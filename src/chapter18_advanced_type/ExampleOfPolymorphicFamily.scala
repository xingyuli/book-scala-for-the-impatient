package chapter18_advanced_type

import scala.collection.mutable.ArrayBuffer
import java.awt.event.ActionEvent

object ExampleOfPolymorphicFamily {

  trait ListenerSupport {
    type S <: Source
    type E <: Event
    type L <: Listener
    
    trait Event {
      var source: S = _
    }
    trait Listener {
      def occurred(e: E): Unit
    }
    trait Source {
      this: S =>
        private val listeners = new ArrayBuffer[L]
        def add(l: L) { listeners += l }
        def remove(l: L) { listeners -= l }
        def fire(e: E) {
          e.source = this
          for (l <- listeners) l.occurred(e)
        }
    }
  }
  
  object ButtonModule extends ListenerSupport {
    type S = Button
    type E = ButtonEvent
    type L = ButtonListener
    class ButtonEvent extends Event
    trait ButtonListener extends Listener
    class Button extends Source {
      def click() { fire(new ButtonEvent) }
    }
  }

}

object Main extends App {
  // the button module must be imported before using
  import ExampleOfPolymorphicFamily.ButtonModule._
  val btn = new Button
  btn.add(new ButtonListener {
    def occurred(e: ButtonEvent) { println("observed") }
  })
  btn.click()
}

object UsingTypeParameterForPolymorphicFamily {
  
  trait Event[S] {
    var source: S = _
  }
  trait Listener[S, E <: Event[S]] {
    def occurred(e: E): Unit
  }
  trait Source[S, E <: Event[S], L <: Listener[S, E]] {
    this: S =>
      private val listeners = new ArrayBuffer[L]
      def add(l: L) { listeners += l }
      def remove(l: L) { listeners -= l }
      def fire(e: E) {
        e.source = this
        listeners.foreach{_.occurred(e)}
      }
  }
  
  class ButtonEvent extends Event[Button]
  trait ButtonListener extends Listener[Button, ButtonEvent]
  class Button extends Source[Button, ButtonEvent, ButtonListener] {
    def click() {
      fire(new ButtonEvent)
    }
  }
  
}