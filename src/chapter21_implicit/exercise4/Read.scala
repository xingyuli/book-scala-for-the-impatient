package chapter21_implicit.exercise4

import scala.collection.mutable.ArrayBuffer

sealed abstract class PossibleInput
case object aString extends PossibleInput
case object anInt extends PossibleInput
case object aDouble extends PossibleInput

object Read extends Iterable[Any] {
  var nextInput: PossibleInput = null
  var queue = ArrayBuffer[Any]()
  
  def in[T <: PossibleInput](obj: T): this.type = { nextInput = obj; this }
  def and[T <: PossibleInput](obj: T): this.type = in(obj)
  
  def askingFor(prompt: String): this.type = {
    Console.printf(prompt + ": ")
    nextInput match {
      case `aString` => queue += Console.readLine()
      case `anInt` => queue += Console.readInt()
      case `aDouble` => queue += Console.readDouble()
    }
    this
  }
  
  def iterator: Iterator[Any] = queue.iterator
}

object Main extends App {
  val r = Read in aString askingFor "Your name" and anInt askingFor "Your age" and aDouble askingFor "Your weight"
  r.foreach { println }
}