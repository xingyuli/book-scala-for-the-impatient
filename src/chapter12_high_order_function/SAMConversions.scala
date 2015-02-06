package chapter12_high_order_function

import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

import javax.swing.JButton
import javax.swing.JFrame

object SAMConversions {

  def main(args: Array[String]) {
    var counter = 0
    
    val button = new JButton("Increment")
    button.addActionListener(new ActionListener {
      override def actionPerformed(event: ActionEvent) {
        counter += 1
        println(counter)
      }
    });
    
    // Use SAM conversions
    implicit def makeAction(action: (ActionEvent) => Unit) = new ActionListener {
      override def actionPerformed(event: ActionEvent) {
        action(event)
      }
    }
    
    val another = new JButton("Decrement")
    another.addActionListener((event: ActionEvent) => {
      counter -= 1
      println(counter)
    })
    
    val frame = new JFrame
    frame.setLayout(new BorderLayout)
    frame.add(button, BorderLayout.WEST)
    frame.add(another, BorderLayout.EAST)
    frame.addWindowListener(new WindowAdapter {
      override def windowClosing(event: WindowEvent) {
        System.exit(0)
      }
    })
    frame.show()
  }
  
}