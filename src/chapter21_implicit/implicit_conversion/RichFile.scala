package chapter21_implicit.implicit_conversion

import java.io.File

import scala.io.Source

class RichFile(val from: File) {
  def read = Source.fromFile(from.getPath).mkString
}