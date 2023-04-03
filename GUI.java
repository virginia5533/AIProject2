import java.awt.*;
import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;


public class GUI {

    /**
    * Creates JFrame to recieve user input.
    *
    * @param none
    *
    * @return void
    */

    public GUI(){

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 5, 30));
        panel.setLayout(new GridLayout(0, 1));


        JLabel directions = new JLabel("Enter text below and hit generate to complete the sentence.");
        JTextArea sentenceTextBox = new JTextArea();
        JButton generate = new JButton("Generate");

        panel.add(directions);
        panel.add(sentenceTextBox);
        panel.add(generate);
        
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Markov Chain Sentence Completion");
        frame.pack();
        frame.setVisible(true);
        

    }

    public static void main(String[] args){
        new GUI();
    }
    
}
