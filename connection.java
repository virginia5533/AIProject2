public class connection {

    String wordA;
    String wordB;
    int weight;


    void setWordA(String initwordA){
        wordA = initwordA;
    }
    
    String getWord(){
        return wordA;
    }
    void setWordB(String initwordB){
        wordB = initwordB;
    }
    
    String getWordB(){
        return wordB;
    }

    void increaseWeight(){
        weight++;
    }

    int getWeight(){
       return weight;
    }
}
