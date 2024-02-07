package utils;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public ArrayList<String> lines = new ArrayList<>();

    public Reader(){
        try {
            readString();
        } catch (IIOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  Method returns all lines from txt file
     */
    public ArrayList<String> readString() throws IIOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/resources/testCasesForFW.txt"));
            String line = null;
            while ((line= br.readLine()) != null) {
                lines.add(line);
                }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return lines;
    }

    /**
    * @name is a key-parameter which value (result) returns method
     */
    public String findString(String name){
        String result = null;
        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).contains(name)){
               result = lines.get(++i);
            }
        }
        return result;
    }
}
