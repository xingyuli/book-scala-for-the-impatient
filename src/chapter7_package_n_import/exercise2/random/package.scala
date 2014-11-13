package chapter7_package_n_import.exercise2

package object random {

  private var prevInt = 0
  private var prevDouble = 0.0
  
  private val a = 1664525
  private val b = 1013904223
  
  def nextInt(): Int = {
    this.prevInt = ((a * this.prevInt) + b) % math.pow(2, 32).toInt
    this.prevInt
  }
  
  def nextDouble(): Double = {
    this.prevDouble = ((a * this.prevDouble) + b) % math.pow(2, 32)
    this.prevDouble
  }
  
  def setSeed(seed: Int): Unit = {
    this.prevInt = seed
    this.prevDouble = seed
  }

}