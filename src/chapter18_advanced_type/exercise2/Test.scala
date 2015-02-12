package chapter18_advanced_type.exercise2

object Test extends App {

  object then
  object show
  object around
  
  class Bug {
    
    private var position = 0
    private var direction = 1
    
    def move(distance: Int): this.type = { position += direction * distance; this }
    
    def turn(obj: around.type): this.type = {
      direction = direction match {
        case 1 => -1
        case -1 => 1
      }
      this
    }
    
    def and(obj: show.type): this.type = { print(position + " "); this }
    
    def and(obj: then.type): this.type = this

  }
  
  val bugsy = new Bug
  bugsy move 4 and show and then move 6 and show turn around move 5 and show
  
}