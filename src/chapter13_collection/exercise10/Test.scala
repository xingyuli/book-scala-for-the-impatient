package chapter13_collection.exercise10

import scala.collection.mutable

object Test {
  
  val article = "sjdfoweiuasnd;ansbpiherphfaskdfhiqwrupahdsf;askdjfskldhgpoiubopadnbjkvanipbyuiyqpweirhknbcvzutqywoiapnbpiztycyaspdofiwenfpbhpaiydfpwefnawenfizyxippfawbhgpqpdbnfghqiwrypqwnsafndqkwstzbabdfqwabhapfhgpawygpasgopryiqprytpqeuirwqenongiqwyrtpqweiurqpwioeurpnaskbnak;sfgqwyerpahdflanskghasipqynasdfnasjkdgfqitwopadfasbdfgadsoiftqowihalsfalskdgfqiturop"

  def main(args: Array[String]) {
    // println(willGiveWrongResult)
    
    println(">>> approach 1")
    countChar(article) foreach println
    
    println(">>> approach 2")
    countChar1(article) foreach println
  }
  
  private def willGiveWrongResult() = {
    val freq = mutable.HashMap[Char, Int]()
    for (c <- article.par) {
      freq(c) = freq.getOrElse(c, 0) + 1
    }
    freq
  }

  // approach 1
  private def countChar(s: String) = s.aggregate(mutable.Map[Char, Int]())(
        (f, c) => { f(c) = f.getOrElse(c, 0) + 1; f },
        (f1, f2) => {
          (mutable.Map[Char, Int]() /: (f1.toList ++ f2.toList)) { (f, p) =>
            f(p._1) = f.getOrElse(p._1, 0) + p._2
            f
          }
        }
      )

  // approach 2: use separated function to merge two maps
  def mergeValues[A, B](x: mutable.Map[A, B], y: mutable.Map[A, B])(z: B, op: (B, B) => B) = {
    (mutable.Map[A, B]() /: (x.toList ++ y.toList)) { (r, p) =>
        r(p._1) = op(r.getOrElse(p._1, z), p._2)
        r
      }
  }

  private def countChar1(s: String) = s.aggregate(mutable.Map[Char, Int]())(
        (f, c) => { f(c) = f.getOrElse(c, 0) + 1; f },
        (f1, f2) => mergeValues(f1, f2)(0, _ + _)
      )

}