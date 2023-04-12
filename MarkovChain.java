import java.util.Scanner;
import java.util.Vector;
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

            while(iStream.hasNext()){

                String newWord = iStream.next();

                
                // make search words functions if no words already {

                word newWordObj = new word();
            

                newWordObj.setWord(prevWord);
                newWordObj.checkConnection(newWord);

                addWord(newWordObj);
            
                prevWord = newWord;
                //////////////////////////////////////////////////////

                // else check connection
                
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
            currentWord.printConnections();

            System.out.println();


        }

    }
}
    
