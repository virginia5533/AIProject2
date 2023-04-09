
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TextFilter {




public static void main(String[] args) throws IOException{

    File wikiFolder = new File("wikiFiles");
    File[] files = wikiFolder.listFiles();

    for(File file : files){
        if(file.isFile()){
            String line;
            BufferedReader iStream = null;
            BufferedWriter oStream = null;
        

        try{
            iStream = new BufferedReader(new FileReader(file));
            oStream = new BufferedWriter(new FileWriter("DataTxt.txt", true));


            while((line = iStream.readLine()) != null){

                //removes special characters and punctuation
                line = line.replaceAll("[-+\"'.,<>?;:|=~`/!@#$%^&*()�_0123456789\\[\\]\\\\]", " ");
                line = line.toLowerCase();
                //System.out.println(line);
                oStream.write(line);
                oStream.write(" ");
            }
        } catch(IOException e){
            System.out.println(e);
        }

        finally {
            if(iStream != null){
                iStream.close();
            }
            if(oStream != null){
                oStream.close();
            }
        }
    }
    }

   


}
}