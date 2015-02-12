package chapter17_type_parameter

object ExampleOfTypeConstraint extends App {

  class Pair[T](val first: T, val second: T) {
    def smaller(implicit ev: T <:< Ordered[T]) = {
      // implicit conversion
      // first => apply(first): Ordered[T]
      if (first < second) first else second
    }
  }
  
  val stuff = Map("a"->1, "b"->2)
  val stuffOpt = stuff.get("c")
  // stuffOpt.orNull
  
  // def firstLast[A, C <: Iterable[A]](it: C) = (it.head, it.last)
  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) = (it.head, it.tail)
  
  firstLast(List(1, 2, 3))
  
}