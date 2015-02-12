package chapter18_advanced_type.exercise1

object Test extends App {

  class Bug {
    
    private var position = 0
    private var direction = 1
    
    def move(distance: Int): this.type = { position += direction * distance; this }
    
    def turn: this.type = {
      direction = direction match {
        case 1 => -1
        case -1 => 1
      }
      this
    }
    
    def show: this.type = { print(position + " "); this }

  }
  
  val bugsy = new Bug
  bugsy.move(4).show.move(6).show.turn.move(5).show
  
}