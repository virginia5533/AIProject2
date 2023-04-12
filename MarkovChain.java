import java.util.Scanner;
import java.util.Vector;
import java.util.Boolean;
import java.io.*;

public class MarkovChain {

    static Vector<word> words = new Vector<word>();

    static void addWord(word newWord){
        words.add(newWord);
    }

    public static void main(String[] args) throws IOException{

        File file = new File("testWord.txt");
        Scanner iStream = new Scanner(file);

        String prevWord = iStream.next();
        System.out.print(prevWord + " ");

            while(iStream.hasNext()){

                String newWord = iStream.next();
                System.out.println("new: " + newWord);

                
                if(searchWords(newWord) == true){
                    getWord(newWord);
                }

                else {
                // make search words functions if no words already {

                word newWordObj = new word();
            

                newWordObj.setWord(prevWord);
                newWordObj.checkConnection(newWord);

                addWord(newWordObj);
            
                prevWord = newWord;
                System.out.println("prev: " +prevWord);
                //////////////////////////////////////////////////////

                // else check connection
                }
            }
            if(iStream != null){
                iStream.close();
            }

            printChain();

        }

    static void printChain(){

        for(int i = 0; i < words.size(); i++){

            word currentWord = words.get(i);
            System.out.print(currentWord.getWord() + " ");
            //currentWord.printConnections();

            Vector<connection> currentWordConnections = currentWord.getConnections();

            for(int i = 0; i < currentWordConnections.size(); i++){

                System.out.println("weight: " + currentWordConnections.get(i).getWeight() + " next word: " + currentWordConnections.get(i).getWordB().getWord());
            }
    
}
            

            System.out.println();


        }

    }

     Boolean searchWords(String input){

        for(int i = 0; i < words.size(); i++){

            if(words.get(i).getWord() == input){
                return true;
            }

        }
        return false;
    }

    static word getWord(String input){

        word wordToFind = new word();

        for(int i = 0; i < words.size(); i++){

            if(words.get(i).getWord() == input){
                return words.get(i);
            }

        }
        
        return wordToFind;
    }
}
    
