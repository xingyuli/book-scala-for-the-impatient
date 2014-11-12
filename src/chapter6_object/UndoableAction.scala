package chapter6_object

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {}
  override def redo() {}
}

object UndoableActionTest {

  def main(args: Array[String]) {
	// open and save feature are not implemented
	val actions = Map("Open" -> DoNothingAction, "Save" -> DoNothingAction)
	println("action: " + actions)
  }

}