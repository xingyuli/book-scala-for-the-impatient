package chapter8_inheritance.object_equality

object Test {

  class Item(val description: String, val price: Double) {

    final override def equals(other: Any) = {
      val that = other.asInstanceOf[Item]
      if (that == null) false
      else description == that.description && price == that.price
    }
    
    final override def hashCode = 13 * description.hashCode + 17 * price.hashCode

  }
  
}