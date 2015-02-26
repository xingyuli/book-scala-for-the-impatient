package chapter21_implicit.exercise2

class Percentage(val value: Int) {
  def +%(acc: Int) = value + acc
}

object Percentage {
  implicit def int2Percentage(v: Int) = new Percentage(v)
}