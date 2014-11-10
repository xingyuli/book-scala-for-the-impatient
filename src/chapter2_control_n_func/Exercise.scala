package chapter2_control_n_func

object Exercise {

  def main(args: Array[String]) {
    println(_1_signum(3))
    println(_1_signum(-3))
    println(_1_signum(0))

    _3_legal_x_eq_y_eq_1()

    _4_for_loop()

    _5_countdown(10)
    _5_recursiveCountdown(10)

    println(_6_product("Hello"))
    println(_7_product("Hello"))
    println(_9_recursive_product("Hello"))

    println(_10_pow(4, 10) == scala.math.pow(4, 10))
  }

  def _1_signum(n: Int) = {
    if (n > 0) 1
    else if (n < 0) -1
    else 0
  }

  def _3_legal_x_eq_y_eq_1() {
    var x: Unit = ()
    var y: Int = 0
    x = y = 1
    printf("demonstrate the scenario of legal expression 'x = y = 1': x=%s, y=%s\n", x, y)
  }

  def _4_for_loop() {
    for (i <- 10.to(0, -1)) println(i)
  }

  def _5_countdown(n: Int) {
    for (i <- n.to(0, -1)) print(i + " ")
  }

  def _5_recursiveCountdown(n: Int) {
    if (n >= 0) {
      print(n + " ")
      _5_recursiveCountdown(n-1)
    }
  }

  def _6_product(str: String) = {
    var result: Long = 1
    for (ch <- str) result *= ch.toLong
    result
  }

  def _7_product(str: String) = {
    var result: Long = 1
    str.foreach { ch => result *= ch.toLong }
    result
  }

  def _9_recursive_product(str: String): Long = {
    if (str.length == 0) 1
    else str.head.toLong * _9_recursive_product(str.tail)
  }

  def _10_pow(x: Int, n: Int): Int = {
    if (n == 0) 1
    else if (n < 0) 1 / _10_pow(x, -n)
    else if (n%2 == 0) { val y = _10_pow(x, n/2); y*y }
    else x*_10_pow(x, n-1)
  }

}
