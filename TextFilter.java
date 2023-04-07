
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TextFilter {




public static void main(String[] args) throws IOException{

    File wikiFolder = new File("wikiFiles");
    File[] files = wikiFolder.listFiles();

    for(File file : files){
        if(file.isFile()){
            String line;
            BufferedReader iStream = null;
        

        try{
            iStream = new BufferedReader(new FileReader(file));
            while((line = iStream.readLine()) != null){
                System.out.println(line);
            }
        } catch(IOException e){
            System.out.println(e);
        }

        finally {
            if(iStream != null){
                iStream.close();
            }
        }
    }
    }

   


}
}