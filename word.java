import java.util.Vector;

public class word {

    private String word;
    Vector<connection> connections = new Vector<>();
    
   /**
    * Mutates word
    *
    * @param int initWord
    *
    * @return none
    */
void setWord(String initword){
    word = initword;
}

  /**
    * Accesses String word
    *
    * @param none
    *
    * @return String word
    */
String getWord(){
    return word;
}

  /**
    * Accesses Vector<connection> connections
    *
    * @param none
    *
    * @return Vector<connection> connections
    */
Vector<connection> getConnections() {
    return connections;
}

/**
    * Creates a connection object to connect the word object to a word that has the value of String wordB.
    * It returns the connection object created.
    *
    * @param String wordB
    *
    * @return connection newConnection
    */
connection createConnection(String wordB){
    connection newConnection = new connection();
    newConnection.setWordA(getWord());
    newConnection.setWordB(wordB);
    newConnection.increaseWeight();
    

    connections.add(newConnection);
    //System.out.println("Connection created from " + getWord() + " to " + newConnection.getWordB());

    return newConnection;

}

  /**
    * Searches Vector<connection> connections for a connection between the word object and another word with a value of String wordB
    *
    * @param String wordB
    *
    * @return tempConnection
    */
connection checkConnection(String wordB){

    connection tempConnection = null;


    for(int i = 0; i < connections.size(); i++){


        //System.out.println("WordA: " + connections.get(i).getWord() + " WordB: " + connections.get(i).getWordB());

        if((connections.get(i).getWord().equals(getWord())) && (connections.get(i).getWordB().equals(wordB))){
            tempConnection = connections.get(i);
            tempConnection.increaseWeight();
            //System.out.println("increase weight");
        }
    }
        if(tempConnection == null){
            tempConnection = createConnection(wordB);
        }

    

    return tempConnection;
}


  /**
    * Prints the connections of the word object
    *
    * @param none
    *
    * @return none
    */
void printConnections(){

    for(int i = 0; i < connections.size(); i++){

        System.out.println("weight: " + connections.get(i).getWeight() + " next word: " + connections.get(i).getWordB());
    }
    
}

/**
    * Searches for connections of the highest weights (up to 3) and random selects one to return as the generated word.
    *
    * @param none
    *
    * @return connection chosen
    */
connection findMaxConnection() {

    connection maxConnection = new connection();

    //Creates chosen object with a connection to "and" with a weight of 1
    connection chosen = new connection();
    chosen.setWordA(word);
    chosen.setWeight(1);
    chosen.setWordB("and");

    Vector<connection> maxConnections = new Vector<connection>();
    Vector<connection> top5Connections = new Vector<connection>();
    int max = -99999;

    for(int i = 0; i < connections.size(); i++){

        //if connections has highest weight, it is added to maxConnections[]
        if(connections.get(i).getWeight() > max){
            max = connections.get(i).getWeight();
            maxConnection = connections.get(i);
            maxConnections.add(maxConnection);
        }
        
    }
    int random = 0;

    //if maxConnections has 2 or more objects add first and second highest connection to top5Connections
    if(maxConnections.size() >= 2){
        top5Connections.add(maxConnections.get(maxConnections.size()-1));
        top5Connections.add(maxConnections.get(maxConnections.size()-2));

        //choose a random connection from the highest values
        random = 0 + (int)(Math.random() * ((1 - 0) + 1));
        chosen = top5Connections.get(random);
    }
    //if maxConnections has 3 or more objects add third highest connection to top5Connections
    if(maxConnections.size() >= 3){
        top5Connections.add(maxConnections.get(maxConnections.size()-3));

        //choose a random connection from the highest values
        random = 0 + (int)(Math.random() * ((2 - 0) + 1));
        chosen = top5Connections.get(random);
    }
    //if maxConnection has a value, add only the one object to top5Connections
    else if (maxConnection != null){
        top5Connections.add(maxConnection);
    }
    //else return the chosen object initialized at the beginning
    else {
        return chosen;
    }
    

    //System.out.println(top5Connections.toString());

    
    return chosen;
}
}
