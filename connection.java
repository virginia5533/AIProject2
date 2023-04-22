public class connection {

    String wordA;
    String wordB;
    int weight = 0;

  /**
    * Mutates wordA
    *
    * @param String initwordA
    *
    * @return none
    */
    void setWordA(String initwordA){
        wordA = initwordA;
    }
    
    /**
    * Accesses WordA
    *
    * @param none
    *
    * @return String wordA
    */
    String getWord(){
        return wordA;
    }

    /**
    * Mutates wordB
    *
    * @param int initwordB
    *
    * @return none
    */
    void setWordB(String initwordB){
        wordB = initwordB;
    }
    
    /**
    * Accesses wordB
    *
    * @param none
    *
    * @return String wordB
    */
    String getWordB(){
        return wordB;
    }


    /**
    * Mutates weight by increasing it by 1
    *
    * @param none
    *
    * @return none
    */
    void increaseWeight(){
        setWeight(getWeight() + 1);
    }


    /**
    * Mutates weight
    *
    * @param int initweight
    *
    * @return none
    */
    void setWeight(int initweight){
        weight = initweight;
    }

    /**
    * Accesses weight
    *
    * @param none
    *
    * @return int weight
    */
    int getWeight(){
       return weight;
    }
}
