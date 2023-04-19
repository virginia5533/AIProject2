import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class MarkovChain {

     Vector<word> words = new Vector<word>();

     void addWord(word newWord){
        System.out.println("Added word " + newWord.getWord());
        words.add(newWord);
        printChain(words);
    }

    public static void main(String[] args) throws IOException{


        File file = new File("testWord.txt");
        Scanner iStream = new Scanner(file);

        MarkovChain markovChain = new MarkovChain();


        word FirstWordObj = new word();

        String prevWord = iStream.next();
        System.out.println("prev: " + prevWord + " ");
        FirstWordObj.setWord(prevWord);
        markovChain.addWord(FirstWordObj);

            while(iStream.hasNext()){

                String newWord = iStream.next();
                System.out.println("new: " + newWord);
                int i = 0;

               //search for existing words 

                    

                    if(getWord(markovChain, newWord)){
                        System.out.println("word already exists "  + newWord + " " + prevWord);
                        markovChain.words.get(i).checkConnection(prevWord, newWord);
                        printChain(markovChain.words);
                        System.out.println();
                        break;
                    }
        

                else {
                // make search words functions if no words already {

                word newWordObj = new word();
            

                newWordObj.setWord(newWord);
                newWordObj.createConnection(prevWord, newWord);

                markovChain.addWord(newWordObj);
                i++;
            
                prevWord = newWord;
                System.out.println("prev: " + prevWord + "\n");
                //////////////////////////////////////////////////////

                // else check connection
                }
            }
            //}
            if(iStream != null){
                iStream.close();
                System.out.println("Closed");
            }

            System.out.println("Words: " + markovChain.words);
            printChain(markovChain.words);

        }

     static void printChain(Vector<word> words){

        for(int i = 0; i < words.size(); i++){

            word currentWord = words.get(i);
            System.out.print(i + ". " + currentWord.getWord() + " ");
            System.out.println();
            //currentWord.printConnections();

            Vector<connection> currentWordConnections = currentWord.getConnections();

            for(int c = 0; c < currentWordConnections.size(); c++){

                System.out.println("weight: " + currentWordConnections.get(c).getWeight() + " connection: " + currentWordConnections.get(c).getWord() + ' ' + currentWordConnections.get(c).getWordB());
            }
    
}
            

            System.out.println();


        }

    


    static Boolean getWord(MarkovChain markovChain, String input){

        

        for(int i = 0; i < markovChain.words.size(); i++){


            if(markovChain.words.get(i).getWord() == input){
                return true;
            }

        }
        
        return false;
    }
}

    
