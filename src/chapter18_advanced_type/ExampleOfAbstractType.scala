package chapter18_advanced_type

import scala.io.Source
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

object ExampleOfAbstractType {
  trait Reader {
    type Contents // declare an abstract type
    def read(fileName: String): Contents
  }
  class StringReader extends Reader {
    type Contents = String // subclass should specify the type
    def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
  }
  class ImageReader extends Reader {
    type Contents = BufferedImage
    def read(fileName: String) = ImageIO.read(new File(fileName))
  }
}

object UsingTypeParameter {
  trait Reader[C] {
    def read(fileName: String): C
  }
  class StringReader extends Reader[String] {
    def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
  }
  class ImageReader extends Reader[BufferedImage] {
    def read(fileName: String) = ImageIO.read(new File(fileName))
  }
}

object ComplexAbstractType {
  trait Reader {
    type In
    type Contents
    def read(in: In): Contents
  }
  class ImageReader extends Reader {
    type In = File
    type Contents = BufferedImage
    def read(file: In) = ImageIO.read(file)
  }
}

object AbstactTypeWithBound {
  trait Listener {
    type Event <: java.util.EventObject // should be subclass of EventObject
  }
  trait ActionListener extends Listener {
    type Event = java.awt.event.ActionEvent
  }
}
