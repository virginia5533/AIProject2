public class connection {

    String wordA;
    word wordB;
    int weight;


    void setWordA(String initwordA){
        wordA = initwordA;
    }
    
    String getWord(){
        return wordA;
    }
    void setWordB(word initwordB){
        wordB = initwordB;
    }
    
    word getWordB(){
        return wordB;
    }

    void increaseWeight(){
        weight++;
    }

    void setWeight(int initweight){
        weight = initweight;
    }

    int getWeight(){
       return weight;
    }
}
