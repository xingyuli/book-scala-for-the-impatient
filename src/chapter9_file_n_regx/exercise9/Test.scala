package chapter9_file_n_regx.exercise9

import scala.util.matching.Regex
import java.io.File
import java.io.FilenameFilter

object Test {

  def main(args: Array[String]) {
    val targetDir = new File(".")
    println(countFilenameMatches(targetDir, ".class"))
  }
  
  def countFilenameMatches(dir: File, extension: String) : Int = {
    var count = 0
    for (f <- dir.listFiles) {
      if (f.isFile() && f.getName().endsWith(extension)) {
        count += 1
        println(f.getAbsolutePath())
      }
      if (f.isDirectory()) {
        count += countFilenameMatches(f, extension)
      }
    }
    count
  }
  
}