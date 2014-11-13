package chapter7_package_n_import.exercise2.random

object Test extends App {

  setSeed(17)
  
  for (i <- 1 until 10) {
    println("nextInt: " + nextInt())
    println("nextDouble: " + nextDouble())
  }
  
}