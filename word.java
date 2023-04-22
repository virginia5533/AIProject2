import java.util.Vector;

public class word {

    private String word;
    Vector<connection> connections = new Vector<>();
    

void setWord(String initword){
    word = initword;
}

String getWord(){
    return word;
}

Vector<connection> getConnections() {
    return connections;
}

connection createConnection(String wordB){
    connection newConnection = new connection();
    newConnection.setWordA(getWord());
    newConnection.setWordB(wordB);
    newConnection.increaseWeight();
    

    connections.add(newConnection);
    //System.out.println("Connection created from " + getWord() + " to " + newConnection.getWordB());

    return newConnection;

}

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



void printConnections(){

    for(int i = 0; i < connections.size(); i++){

        System.out.println("weight: " + connections.get(i).getWeight() + " next word: " + connections.get(i).getWordB());
    }
    
}


connection findMaxConnection() {

    connection maxConnection = new connection();
    connection chosen = new connection();
    chosen.setWordA(word);
    chosen.setWeight(1);
    chosen.setWordB("and");
    Vector<connection> maxConnections = new Vector<connection>();
    Vector<connection> top5Connections = new Vector<connection>();
    int max = -99999;

    for(int i = 0; i < connections.size(); i++){

        if(connections.get(i).getWeight() > max){
            max = connections.get(i).getWeight();
            maxConnection = connections.get(i);
            maxConnections.add(maxConnection);
        }
        
    }
    int random = 0;

    if(maxConnections.size() >= 2){
        top5Connections.add(maxConnections.get(maxConnections.size()-1));
        top5Connections.add(maxConnections.get(maxConnections.size()-2));
        random = 0 + (int)(Math.random() * ((1 - 0) + 1));
        chosen = top5Connections.get(random);
    }
    if(maxConnections.size() >= 3){
        top5Connections.add(maxConnections.get(maxConnections.size()-3));
        random = 0 + (int)(Math.random() * ((2 - 0) + 1));
        chosen = top5Connections.get(random);
    }
    else if (maxConnection != null){
        top5Connections.add(maxConnection);
    }
    else {
        return chosen;
    }
    

    System.out.println(top5Connections.toString());

    

    


    return chosen;
}
}
