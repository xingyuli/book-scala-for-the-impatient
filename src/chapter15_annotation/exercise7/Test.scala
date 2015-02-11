package chapter15_annotation.exercise7

import scala.annotation.varargs
import scala.annotation.tailrec

class Test {

  @tailrec private def sum(xs: Seq[Int], partial: Int): BigInt = 
    if (xs.isEmpty) partial else sum(xs.tail, xs.head + partial)

}