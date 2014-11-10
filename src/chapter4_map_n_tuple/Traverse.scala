package chapter4_map_n_tuple

object Traverse {

  def main(args: Array[String]) {
    val dict = Map(
        "a" -> Array("an", "and", "another"),
        "b" -> Array("but", "bother", "brother"),
        "c" -> Array("can", "carry", "carrot"))
    for ((ch, words) <- dict) {
      println("'" + ch + "' associated with words " + words.mkString("[ ", ", ", " ]"))
    }

    dict.keySet.foreach(index => println("index: " + index))
    dict.values.foreach(words => println("words: " + words.mkString(", ")))
  }
  
}