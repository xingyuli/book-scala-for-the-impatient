package chapter21_implicit.exercise9

object Test extends App {

  trait Intf {
    
    def m[A, B](v: A)(implicit ev: A =:= B)
    
    /*
     * From Predef.scala, we know that
     *   sealed abstract class =:=[From, To] extends (From => To)
     *     with Serializable
     * 
     * It means we need an implicit value with type of:
     *   =:=[A, B]
     * 
     * At the same time, =:= is a Function1[A, B]. You should notice that type
     * A is neither invariant nor covariant.
     * 
     * In the companion object of =:=
     *   object =:= {
     *     implicit def tpEquals[A]: A =:= A = singleton_=:=.asInstanceOf[A =:= A]
     *   }
     * which means we have an implicit value with type of:
     *   =:=[A, A]
     * 
     * Remember that our need is a
     *   =:=[A, B]
     * 
     * So, as long as type A is same with type B, the compiler will not
     * complain any more.
     */
    
  }
  
}