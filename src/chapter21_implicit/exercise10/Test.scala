package chapter21_implicit.exercise10

object Test extends App {

  /*
   * The signature of map method is:
   *   def map[B, That](f: A => B)(implicit bf: CanBuildFrom[Repr, B, That]): That
   * 
   * Refer to StringOps.scala:
   *   final class StringOps(override val repr: String) extends AnyVal with StringLike[String]
   *   
   * Refer to StringLike.scala:
   *   trait StringLike[+Repr] extends Any with scala.collection.IndexedSeqOptimized[Char, Repr]
   * 
   * Thus for the String case, the map method can be viewed as:
   *   def map[B, That](f: Char => B)(implicit bf: CanBuildFrom[String, B, That]): That
   * 
   * This requires that
   *   1) it should be possible to create a collection with type of That, whose
   *   element has type of B. (For simplicity, I write it as That[B])
   *   2) type That should be compatible with type String
   */

  /*
   * For "_.toUpper", implies a possibility to create That[Char], compatible with String.
   * 
   * Typing ":implicits -v" in the REPL, I found that in Predef.scala:
   *   implicit val StringCanBuildFrom: CanBuildFrom[String, Char, String] = new CanBuildFrom[String, Char, String] {
   *     def apply(from: String) = apply()
   *     def apply()             = mutable.StringBuilder.newBuilder
   *   }
   *
   * In StringBuilder.scala;
   *   def result(): String = toString
   * 
   * So, the final result is a String.      
   */
	println("abc".map { _.toUpper })

  /*
   * For "_.toInt", implies a possibility to create That[Int], compatible with String.
   * 
   * In LowPriorityImplicits.scala:
   *   implicit def fallbackStringCanBuildFrom[T]: CanBuildFrom[String, T, immutable.IndexedSeq[T]] =
   *     new CanBuildFrom[String, T, immutable.IndexedSeq[T]] {
   *       def apply(from: String) = immutable.IndexedSeq.newBuilder[T]
   *       def apply() = immutable.IndexedSeq.newBuilder[T]
   *     }
   * 
   * In IndexedSeq.scala:
   *   def newBuilder[A]: Builder[A, IndexedSeq[A]] = Vector.newBuilder[A]
   * 
   * In Vector.scala:
   *   def newBuilder[A]: Builder[A, Vector[A]] = new VectorBuilder[A]
   * 
   * In VectorBuilder.scala:
   *   def result: Vector[A] = { ... }
   * 
   * So, the final result is a Vector.
   */
  println("abc".map { _.toInt })

}