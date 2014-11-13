package chapter7_package_n_import.exercise9

object Test extends App {
  val username = System.getProperty("user.name")
  val password = Console.readLine("Your password: ")
  if ("secret" != password) {
    Console.err.println("Invalid password!")
  } else {
    println("Hello " + username + "!")
  }
}