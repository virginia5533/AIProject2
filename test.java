import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test {

    int sentenceNum = 0;
    int success = 0;
    double fraction;

    void setSentenceNum(int initSentenceNum) {
        sentenceNum = initSentenceNum;
    }

    int getSentenceNum() {
        return sentenceNum;
    }

    void setSuccess(int initSuccess) {
        success = initSuccess;
    }

    int getSuccess() {
        return success;
    }


    public double testRun() throws IOException {

    String testInput;
    String testOutput;
    

    
    MarkovChain markovChain = new MarkovChain();
    try {
        markovChain = markovChain.createChain();
    } catch (IOException e1) {
        
        e1.printStackTrace();
    }

    File file = new File("testWord.txt");
    Scanner iStream = new Scanner(file);

    while(iStream.hasNextLine()){
    setSentenceNum(getSentenceNum() + 1);

    String testSentence = iStream.nextLine();
    System.out.println(testSentence);
    String testArr[] = testSentence.split(" ");

    testInput = testArr[1];
    testOutput = testArr[2];


    System.out.println("Searching for: " + testInput);

    //markovChain.printChain(markovChain.getMCWords());

    testInput = testInput.toLowerCase();

    String generatedWord = markovChain.getGeneratedWord(markovChain.getMCWords(), testInput);

    if(generatedWord.equals(testOutput)){
        System.out.println(generatedWord + " equals " + testOutput);
        setSuccess(getSuccess() + 1);
    }
    else{
        System.out.println(generatedWord + " does not equal " + testOutput);
        
    }

    System.out.println("Success: " + success);
    System.out.println("Sentences: " + sentenceNum);

    double successD = success;
    double SentNumD = sentenceNum;
    fraction = successD/SentNumD;
    //System.out.println("Tested with " + String.format("%.2f", (fraction)*100) + "% accuracy");

    }

    if(iStream != null){
        iStream.close();
        //System.out.println("Closed");
    }

    //System.out.println("Tested with " + String.format("%.2f", (fraction)*100) + "% accuracy");
    
    return(fraction*100);

}

public test() throws IOException {

    double accuracySum = 0.0;
    int numberOfRuns = 20;

    for(int i = 0; i < numberOfRuns; i++){
        accuracySum = accuracySum + testRun();
    }
        System.out.println("Tested with " + String.format("%.2f", (accuracySum/numberOfRuns)) + "% accuracy");
}
}
