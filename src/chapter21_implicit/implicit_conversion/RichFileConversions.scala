package chapter21_implicit.implicit_conversion

import java.io.File

object RichFileConversions {
    implicit def file2RichFile(f: File) = new RichFile(f)
}