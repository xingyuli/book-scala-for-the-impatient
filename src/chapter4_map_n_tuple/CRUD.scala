package chapter4_map_n_tuple

object CRUD {

  def main(args: Array[String]) {
    // create an immutable Map[String, Int]
    val immutableScores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    // create an mutable Map[String, Int]
    val scores = scala.collection.mutable.Map(
      ("Alice", 10),
      ("Bob", 3),
      ("Cindy", 8))
    println("scores: " + scores)

    // to create an empty map, specify the map implementation and type info
    val emptyScores = scala.collection.mutable.HashMap[String, Int]()
    println("emptyScores: " + emptyScores)

    val bobScore = scores("Bob")
    val haryScore = if (scores.contains("Hary")) scores("Hary") else 0
    val jayScore = scores.getOrElse("Jay", -1)
    println("bob = " + bobScore + ", hary = " + haryScore + ", jay = " + jayScore)
    
    scores("Bob") = 10
    scores("Fred") = 7
    println("scores: " + scores)
    
    scores += ("Hary" -> 10, "Jay" -> 7)
    scores -= "Alice"
    println("scores: " + scores)
  }

}