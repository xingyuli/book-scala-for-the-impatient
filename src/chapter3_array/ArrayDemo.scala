package chapter3_array

object ArrayDemo {

  def main(args: Array[String]) {
    val num = new Array[Int](10)
    num.foreach(n => print(n + " "))

    val a = new Array[String](10)
    a.foreach(el => print(el + " "))

    val s = Array("Hello", "World")
    s(0) = "GoodBye"
    println(s.mkString(" "))
  }

}