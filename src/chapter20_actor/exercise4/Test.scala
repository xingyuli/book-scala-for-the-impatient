package chapter20_actor.exercise4

import java.io.File

import scala.collection.mutable.ArrayBuffer

import scala.actors.Actor
import scala.actors.Actor._
import scala.actors.TIMEOUT
import scala.io.Source

object Test extends App {

  case class Task(file: String, pattern: String)
  case class PartialResult(file: String, pattern: String, matches: Seq[String])
  
  class PartialCounter(next: Actor) extends Actor {
    def act(): Unit = {
      receive {
        case Task(file, pattern) =>
          val matches = findWords(file, pattern)
          if (!matches.isEmpty) next ! PartialResult(file, pattern, matches)
      }
    }
    private def findWords(file: String, pattern: String): Seq[String] = {
      Source.fromFile(file, "UTF-8").getLines().foldLeft(ArrayBuffer[String]()) { (m, line) =>
        pattern.r findAllIn line foreach { m += _ }
        m
      }
    }
  }
  
  class FinalCounter(next: Actor) extends Actor {
    def act(): Unit = {
      while (true) {
        receiveWithin(1000) {
          case PartialResult(file, pattern, matches) => println(file + " ...\n\t" + matches.mkString(","))
          case TIMEOUT => exit()
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