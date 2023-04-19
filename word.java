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

connection createConnection(String prev, String current){
    connection newConnection = new connection();
    newConnection.setWordA(prev);
    newConnection.setWordB(current);
    newConnection.setWeight(1);

    connections.add(newConnection);
    System.out.println("Connection created from " + getWord() + " to " + newConnection.getWordB());

    return newConnection;

}

connection checkConnection(String prev, String current){

    connection tempConnection = new connection();


    for(int i = 0; i < connections.size(); i++){

        if(connections.get(i).getWord() == prev){
            tempConnection = connections.get(i);
            tempConnection.increaseWeight();
            System.out.println("increase weight");
        }
        else{
            tempConnection = createConnection(prev, current);
        }

    }

    return tempConnection;
}



void printConnections(){

    for(int i = 0; i < connections.size(); i++){

        System.out.println("weight: " + connections.get(i).getWeight() + " next word: " + connections.get(i).getWordB());
    }
    
}
}
