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

connection createConnection(word wordB){
    connection newConnection = new connection();
    newConnection.setWordA(getWord());
    newConnection.setWordB(wordB);
    newConnection.increaseWeight();

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

        System.out.println(connections.get(i).getWeight() + " " + connections.get(i).getWordB().getWord());
    }
    
}
}
