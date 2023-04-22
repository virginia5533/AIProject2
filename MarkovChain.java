import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class MarkovChain {

     Vector<word> words = new Vector<word>();

    /**
    * Adds new word object Vector<word> words
    *
    * @param word newWord
    *
    * @return none
    */
     void addWord(word newWord){
        //System.out.println("Added word " + newWord.getWord());
        words.add(newWord);
        //printChain(words);
    }

    /**
    * Accesses Vector<word> words
    *
    * @param void
    *
    * @return Vector<word> words
    */
    Vector<word> getMCWords() {
        return words;
    }

    /**
    * Creates the Markov Chain by reading in each word from DataTxt.txt.
      When the word is read, it makes a connection to "and" to ensure a response.
      If there is a previous word, it creates a connection for that previous word that connects it to the word that was read.
      If the word read already has a connection to the previous word, that connection's weight is increased.
    *
    * @param word newWord
    *
    * @return none
    */

    MarkovChain createChain() throws IOException{


        //reads in DataTxt.txt
        File file = new File("DataTxt.txt");
        Scanner iStream = new Scanner(file);

        MarkovChain markovChain = new MarkovChain();


        word FirstWordObj = new word();

        String prevWord = iStream.next();
        //System.out.println("prev: " + prevWord + " ");
        FirstWordObj.setWord(prevWord);
        markovChain.addWord(FirstWordObj);

            while(iStream.hasNext()){

                String newWord = iStream.next();
                //System.out.println("new: " + newWord);
                //int i = 0;

               //search for existing words 

                    
                int index = getWord(markovChain.words, newWord);
                    if(index >= 0){
                        //System.out.println("word already exists "  + newWord);
                        markovChain.words.get(getWord(markovChain.words, prevWord)).checkConnection(newWord);
                        //printChain(markovChain.words);
                        //System.out.println();
                        
                    }
        

                else {
                // make search words functions if no words already {

                word newWordObj = new word();

                //ensures every word has at least one recommendation
                connection initconnection = new connection();
                initconnection.setWordA(newWord);
                initconnection.setWordB("and");
                initconnection.setWeight(0);

                newWordObj.setWord(newWord);
                newWordObj.getConnections().add(initconnection);
               

                //gets prevWord and checks if newWord has followed it before
                markovChain.words.get(getWord(markovChain.words, prevWord)).checkConnection(newWord);

                markovChain.addWord(newWordObj);
                
                }

                prevWord = newWord;
                
                
            }//end while loop

            //Close iStream
            if(iStream != null){
                iStream.close();
                //System.out.println("Closed");
            }

            //System.out.println("Words: " + markovChain.words);
            printChain(markovChain.words);

            return markovChain;
        }

    /**
    * Prints the words in the Markov chain and their respective connections if the weight is greater than or equal to 5.
    *
    * @param word newWord
    *
    * @return none
    */
     void printChain(Vector<word> words){

        for(int i = 0; i < words.size(); i++){

            word currentWord = words.get(i);
            //System.out.print(i + ". " + currentWord.getWord() + " ");
            //System.out.println();
            //currentWord.printConnections();

            Vector<connection> currentWordConnections = currentWord.getConnections();

            for(int c = 0; c < currentWordConnections.size(); c++){

                if(currentWordConnections.get(c).weight >= 5){
                //System.out.println("weight: " + currentWordConnections.get(c).getWeight() + " connection: " + currentWordConnections.get(c).getWord() + ' ' + currentWordConnections.get(c).getWordB());
                }
            }
    
        }
            

            System.out.println();


    }

    /**
    * Returns the suggested word after calling the word object matching input.
    *
    * @param Vector<word> markovChainWords
    * @param String input
    *
    * @return String generatedWord or "and"
    */
        String getGeneratedWord(Vector<word> markovChainWords, String input){

            for(int i = 0; i < markovChainWords.size(); i++){

                if(markovChainWords.get(i).getWord().equals(input)){
                    //System.out.println(markovChainWords.get(i).getWord() + " = " + input);

                    word foundWord = markovChainWords.get(i);
                    connection maxConnection = foundWord.findMaxConnection();
                    String generatedWord = maxConnection.getWordB();

                    return generatedWord;
                    
                }
    
            }
            System.out.println("input not found in words");
            return "and";
        }

    /**
    * Gets the index of a word object in Vector<word> words based off of input.
    * If it returns -1, there is no word in words that matches the input.
    *
    * @param Vector<word> markovChainWords
    * @param String input
    *
    * @return int i or '-1'
    */
     int getWord(Vector<word> markovChainWords, String input){

        

        for(int i = 0; i < markovChainWords.size(); i++){


            if(markovChainWords.get(i).getWord().equals(input)){
                //System.out.println(markovChainWords.get(i).getWord() + " = " + input);
                return i;
                
            }

        }
        //System.out.println("No Match");
        return -1;
    }
}

    
