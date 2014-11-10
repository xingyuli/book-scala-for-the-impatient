package chapter2_control_n_func

object Function {

  def main(args: Array[String]) {
    println("abs: " + abs(1.1234))
    println("abs: " + abs(-1.1234))

    println("fac: " + fac(5))
    println("recursiveFac: " + recursiveFac(5))

    println("decorate: " + decorate("Scala"))
    println("decorate: " + decorate("Scala", "<-- ", " -->"))
    // utilize named parameter
    println("decorate: " + decorate(left = "<<<", str = "Scala", right = ">>>"))

    println("sum: " + sum(1, 2, 3, 4))
    println("recursiveSum: " + recursiveSum(1 to 4: _*))

    box("Hello")
  }

  /* **************** 2.7 **************** */

  def abs(x: Double) = if (x >= 0) x else -x

  def fac(n : Int) = {
    var r = 1
    for (i <- 1 to n) r = r * i
    r
  }

  // recursive function should specify return type
  def recursiveFac(n: Int): Int = {
    if (n == 1) 1
    else n * recursiveFac(n - 1)
  }

  /* **************** 2.8 **************** */

  // with default parameter value
  def decorate(str: String, left: String = "[", right: String = "]") = left + str + right

  // the type of args is Seq
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result += arg
    result
  }

  /* **************** 2.9 **************** */

  def recursiveSum(args: Int*): Int = {
    if (args.length == 0) 0
    else args.head + recursiveSum(args.tail: _*)
  }

  /***************** 2.10 **************** */

  // procedure have no return value
  def box(s: String) {
    val border = "-" * s.length + "--\n"
    println(
      border +
      "|" + s + "|\n" +
      border)
  }

}
