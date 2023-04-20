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
    int max = -99999;

    for(int i = 0; i < connections.size(); i++){

        if(connections.get(i).getWeight() > max){
            max = connections.get(i).getWeight();
            maxConnection = connections.get(i);
        }
        
    }


    return maxConnection;
}
}
