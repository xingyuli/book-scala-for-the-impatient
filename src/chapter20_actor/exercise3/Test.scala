package chapter20_actor.exercise3

import java.io.File

import scala.actors.Actor
import scala.actors.Actor._
import scala.actors.TIMEOUT
import scala.io.Source

object Test extends App {
  
  case class Task(file: String, pattern: String)
  case class PartialResult(file: String, pattern: String, count: Int)
  
  class PartialCounter(next: Actor) extends Actor {
    def act(): Unit = {
      receive {
        case Task(file, pattern) =>
          val count = countWords(file, pattern)
          if (count != 0) next ! PartialResult(file, pattern, count)
      }
    }
    private def countWords(file: String, pattern: String): Int = {
      Source.fromFile(file, "UTF-8").getLines().foldLeft(0) { (c, l) =>
        c + pattern.r.findAllIn(l).size
      }
    }
  }
  
  class FinalCounter(next: Actor) extends Actor {
    def act(): Unit = {
      var counter = 0
      while (true) {
        receiveWithin(1000) {
          case PartialResult(file, pattern, count) =>
            counter += count
            println(file + " ... partial count: " + count)
          case TIMEOUT =>
            println("final count: " + counter)
            exit()
        }
      }
    }
  }
  
  actor {
    val pattern = "a.r\\w*"
    val dir = """D:\project\GitHub\scala-for-the-impatient\src"""
    
    val finalCounter = new FinalCounter(self).start
    
    def scan(file: File) {
      if (file.isFile) new PartialCounter(finalCounter).start ! Task(file.getAbsolutePath, pattern)
      else file.listFiles().foreach { scan(_) }
    }
    scan(new File(dir))
  }
  
}