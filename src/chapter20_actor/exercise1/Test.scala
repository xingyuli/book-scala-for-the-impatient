package chapter20_actor.exercise1

import scala.math._
import scala.collection.mutable.ArrayBuffer
import scala.actors.Actor
import scala.actors.TIMEOUT
import scala.actors.Actor._

object Test extends App {

  def randomArray(size: Int): Array[Int] = {
    val arr = ArrayBuffer[Int]()
    for (i <- 1 to size) arr += (random * size).toInt
    arr.toArray
  }
  
  def avg(arr: Array[Int], from: Int, to: Int): Int = {
    var sum: BigInt = 0
    for (i <- from until to) sum += arr(i)
    val result = sum / (to - from)
    result.toInt
  }
  
  def timed(label: String)(body: => Unit): Unit = {
    val start = System.currentTimeMillis
    body
    println("[" + label + "] time consumed: " + (System.currentTimeMillis - start) + "ms")
  }


  case class Task(from: Int, to: Int)
  case class RangeAvg(from: Int, to: Int, avg: Int)
  case class FinalAvg(avg: Int)


  class RangeAvgActor(arr: Array[Int], next: Actor) extends Actor {
    override def act() {
      receive {
        case Task(from, to) => next ! RangeAvg(from, to, avg(arr, from, to))
      }
    }
  }
  
  class FinalAvgActor(subresult: Int, next: Actor) extends Actor {
    override def act() {
      var finalAvg = 0
      var subresultCounter = 0
      while (subresultCounter < subresult) {
        receive {
          case RangeAvg(from, to, avg) =>
            finalAvg = if (finalAvg == 0) avg else (finalAvg + avg) / 2
            subresultCounter += 1
        }
      }
      next ! FinalAvg(finalAvg)
    }
  }

  val limit = 1000000
  val data = randomArray(limit)
  
  actor {
    val workerSize = 4
    val finalAvgActor = new FinalAvgActor(workerSize, self).start()
    
    val workers = ArrayBuffer[Actor]()
    for (i <- 0 until workerSize) workers += new RangeAvgActor(data, finalAvgActor).start
    
    timed("multi-threaded avg") {
      val piece = limit / workerSize
      for (i <- 0 until workerSize) workers(i) ! Task(piece * i, piece * (i+1))
      
      receive {
        case FinalAvg(finalAvg) => println("multi-threaded avg: " + finalAvg)
      }
    }
  }
  
  timed("single-threaded avg") {
    println("single-threaded avg: " + avg(data, 0, limit))
  }

}