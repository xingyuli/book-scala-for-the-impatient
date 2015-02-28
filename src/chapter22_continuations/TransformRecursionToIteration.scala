package chapter22_continuations

import java.io.File

import scala.util.continuations._

object Recursion {
  
  def processDirectory(dir: File) {
    val files = dir.listFiles
    for (f <- files) {
      if (f.isDirectory) processDirectory(f)
      else println(f)
    }
  }
  
}

object TransformRecursionToIteration extends App {
  
  var cont: (Unit => Unit) = null
  
  def processDirectory(dir: File): Unit @cps[Unit] = {
    val files = dir.listFiles
    var i = 0
    while (i < files.length) {
      val f = files(i)
      i += 1
      if (f.isDirectory) processDirectory(f)
      else {
        shift {
          k: (Unit => Unit) => {
            cont = k
          }
        }
        println(f)
      }
    }
  }
  
  reset { processDirectory(new File("src")) }
  for (i <- 1 to 100) cont() // executed 101 times, the 1rst time will only assign the k to cont
  
}