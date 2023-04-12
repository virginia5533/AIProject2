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

connection createConnection(word wordB){
    connection newConnection = new connection();
    newConnection.setWordA(getWord());
    newConnection.setWordB(wordB);
    newConnection.setWeight(1);

    connections.add(newConnection);

    return newConnection;

}

connection checkConnection(String wordB){

    connection tempConnection = new connection();
    word newWord = new word();

    for(int i = 0; i < connections.size(); i++){

        if(connections.get(i).getWordB().getWord() == wordB){
            tempConnection = connections.get(i);
            tempConnection.increaseWeight();
        }
        else{
            newWord.setWord(wordB);
            tempConnection = createConnection(newWord);
        }

    }

    return tempConnection;
}



void printConnections(){

    for(int i = 0; i < connections.size(); i++){

        System.out.println("weight: " + connections.get(i).getWeight() + " next word: " + connections.get(i).getWordB().getWord());
    }
    
}
}
