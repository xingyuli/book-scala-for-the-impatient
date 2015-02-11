package chapter15_annotation

import scala.util.control.TailCalls

object ExampleOfTailCalls extends App {

  def evenLength(xs: Seq[Int]): TailCalls.TailRec[Boolean] = 
    if (xs.isEmpty) TailCalls.done(true) else TailCalls.tailcall(oddLength(xs.tail))
  
  def oddLength(xs: Seq[Int]): TailCalls.TailRec[Boolean] = 
    if (xs.isEmpty) TailCalls.done(false) else TailCalls.tailcall(evenLength(xs.tail))
  
  println(evenLength(1 to 1000000).result)

}