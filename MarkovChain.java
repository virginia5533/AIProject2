import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class MarkovChain {

     Vector<word> words = new Vector<word>();

     void addWord(word newWord){
        //System.out.println("Added word " + newWord.getWord());
        words.add(newWord);
        //printChain(words);
    }

    Vector<word> getMCWords() {
        return words;
    }

    MarkovChain createChain() throws IOException{


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
                //newWordObj.createConnection(prevWord, newWord);

                //gets prevWord and checks if newWord has followed it before
                markovChain.words.get(getWord(markovChain.words, prevWord)).checkConnection(newWord);

                markovChain.addWord(newWordObj);
                //i++;
            
                
                //////////////////////////////////////////////////////

                // else check connection
                }

                prevWord = newWord;
                
                
            }
            //}
            if(iStream != null){
                iStream.close();
                //System.out.println("Closed");
            }

            //System.out.println("Words: " + markovChain.words);
            printChain(markovChain.words);

            return markovChain;
        }

     void printChain(Vector<word> words){

        for(int i = 0; i < words.size(); i++){

            word currentWord = words.get(i);
            //System.out.print(i + ". " + currentWord.getWord() + " ");
            //System.out.println();
            //currentWord.printConnections();

            Vector<connection> currentWordConnections = currentWord.getConnections();

            for(int c = 0; c < currentWordConnections.size(); c++){

                if(currentWordConnections.get(c).weight >= 5){
                System.out.println("weight: " + currentWordConnections.get(c).getWeight() + " connection: " + currentWordConnections.get(c).getWord() + ' ' + currentWordConnections.get(c).getWordB());
                }
            }
    
}
            

            System.out.println();


        }

    
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

    
