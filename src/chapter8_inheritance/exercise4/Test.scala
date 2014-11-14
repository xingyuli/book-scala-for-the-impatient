package chapter8_inheritance.exercise4

object Test extends App {

  abstract class Item {
    def price: Double
    def description: String
  }
  
  class SimpleItem(val price: Double, val description: String) extends Item
  
  class Bundle(val description: String) extends Item {
    
    private val items = new scala.collection.mutable.ArrayBuffer[Item]
    
    def price = {
      var result = 0.0
      items.foreach { result += _.price }
      result
    }
    
    def add(item: Item) {
      items += item
    }
    
  }
  
  val b = new Bundle("Test Bundle")
  b.add(new SimpleItem(1.1, "item1"))
  b.add(new SimpleItem(2.2, "item2"))
  b.add(new SimpleItem(3.3, "item3"))
  
  println("price of " + b.description + ": " + b.price)
  
}