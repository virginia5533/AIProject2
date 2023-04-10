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

connection createConnection(String wordB){
    connection newConnection = new connection();
    newConnection.setWordA(getWord());
    newConnection.setWordB(wordB);
    newConnection.increaseWeight();

    connections.add(newConnection);

    return newConnection;

}

connection getConnection(String wordB){

    connection tempConnection = new connection();

    for(int i = 0; i < connections.size(); i++){

        if(connections.get(i).getWordB() == wordB){
            tempConnection = connections.get(i);
            tempConnection.increaseWeight();
        }
        else{
            tempConnection = createConnection(wordB);
        }

    }

    return tempConnection;
}

}
