package chapter6_object

object Exercise {

  def main(args: Array[String]) {
	println(">>> demo 1st")
    println("3.14 inches is " + Conversions.inchesToCentimeters(3.14) + " cm")
    println("3.14 gallons is " + Conversions.gallonsToLiters(3.14) + " l")
    println("3.14 miles is " + Conversions.milesToKimeters(3.14) + " km")

    println(">>> demo 2nd")
    println("3.14 inches is " + InchesToCentimeters.convert(3.14) + " cm")
    println("3.14 gallons is " + GallonsToLiters.convert(3.14) + " l")
    println("3.14 miles is " + MilesToKimeters.convert(3.14) + " km")

    println(">>> demo 4th")
    val p = Point(3, 4)
    println("p.x=" + p.x + ", p.y=" + p.y)

    if (args.length > 0) {
      println(">>> demo 5th")
      println(args.reverse.mkString(" "))
    }

    println(">>> demo 6th")
    for (color <- PokerColor.values) println(color)
    
    println(">>> demo 7th")
    val cardA = new PokerCard(10, PokerColor.Club)
    val cardB = new PokerCard(4, PokerColor.Heart)
    println("Is cardA in heart? " + PokerCard.isHeart(cardA))
    println("Is cardB in heart? " + PokerCard.isHeart(cardB))
  }
  
}

/* 1st */

object Conversions {

  def inchesToCentimeters(inche: Double) = 2.54 * inche
  
  def gallonsToLiters(gallon: Double) = 4.546 * gallon
  
  def milesToKimeters(mile: Double) = 1.609 * mile

}

/* 2nd */

abstract class UnitConversion {
  def convert(amount: Double) = rate * amount
  def rate: Double
}

object InchesToCentimeters extends UnitConversion {
  override def rate = 2.54
}

object GallonsToLiters extends UnitConversion {
  override def rate = 4.546
}

object MilesToKimeters extends UnitConversion {
  override def rate = 1.609
}

/* 4th */

object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

class Point(var x: Int, var y: Int)

/* 6th */

object PokerColor extends Enumeration {
  val Heart = Value("\u2665")
  val Spade = Value("\u2660")
  val Diamond = Value("\u2666")
  val Club = Value("\u2663")
}

/* 7th */

object PokerCard {
  def isHeart(card: PokerCard) = card.color == PokerColor.Heart
}

class PokerCard(val point: Int, val color: PokerColor.Value)

/* 8th */

object RGBColor extends Enumeration {
  val Red = Value(0xff0000)
  val Green = Value(0x00ff00)
  val Blue = Value(0x0000ff)
}