import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

    String userInput;

    

    public GUI() throws IOException{

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
        

        

        generate.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String userInput;
                userInput = sentenceTextBox.getText();

                MarkovChain markovChain = new MarkovChain();
                try {
                    markovChain = markovChain.createChain();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }

                System.out.println("Input: " + userInput);
                String inputArr[] = userInput.split(" ");
                String wordToSuggest = inputArr[inputArr.length-1];

                System.out.println("Searching for: " + wordToSuggest);

                markovChain.printChain(markovChain.getMCWords());

                String generatedWord = markovChain.getGeneratedWord(markovChain.getMCWords(), wordToSuggest);

                   sentenceTextBox.setText(sentenceTextBox.getText() + " " + generatedWord);
    

            }

        } );

        

        

    }

    public static void main(String[] args){
      //  new GUI();
    }
    
}
