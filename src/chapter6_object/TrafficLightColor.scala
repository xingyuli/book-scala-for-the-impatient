package chapter6_object

object TrafficLightColor extends Enumeration {
  val Red = Value("Customized Red")
  val Yellow, Green = Value
}

object TrafficLightColorTest extends App {
  for (c <- TrafficLightColor.values) println(c.id + ": " + c)
  println(TrafficLightColor(1))
  println(TrafficLightColor.withName("Green"))
}
