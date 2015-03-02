package chapter22_continuations

import javax.swing.JFrame
import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import javax.swing.JTextArea
import javax.swing.JLabel
import java.awt.BorderLayout
import javax.swing.JPanel

import scala.util.continuations._

object ExampleInGUI extends App {  

  val label = new JLabel("Welcome to the demo app")
  val textField = new JTextArea(10, 40)
  
  val button = new JButton("Next")
  setListener(button) { run() }
  
  val panel = new JPanel
  panel.add(button)

  val frame = new JFrame
  frame.add(label, BorderLayout.NORTH)
  frame.add(textField)
  frame.add(panel, BorderLayout.SOUTH)
  frame.pack()
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setVisible(true)
 
  
  def run() {
    reset {
      val response1 = getResponse("What is your first name?")
      val response2 = getResponse("What is your last name?")
      process(response1, response2)
    }
  }
  
  def process(s1: String, s2: String) {
    label.setText("Hello, " + s1 + " " + s2)
  }
  
  var cont: Unit => Unit = null
  
  def getResponse(prompt: String): String @cps[Unit] = {
    label.setText(prompt)
    setListener(button) { cont() }
    
    shift { k: (Unit => Unit) => {
        cont = k
      }
    }
    
    setListener(button) { }
    textField.getText
  }
  
  def setListener(button: JButton)(action: => Unit) {
    for (l <- button.getActionListeners) button.removeActionListener(l)
    button.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent) { action }
    })
  }
  
}