package chapter2_control_n_func

object For {

  def main(args: Array[String]) {
    println(for (i <- 1 to 10) yield i % 3)

    println(for (c <- "Hello"; i <- 0 to 1) yield (c+i).toChar)

    for { i <- 1 to 3
      from = 4 - i
      j <- from to 3
    } {
      print((10 * i + j) + " ")
    }
  }

}
