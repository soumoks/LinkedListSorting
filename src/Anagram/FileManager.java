package Anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * The type File manager.
 */
public class FileManager {

    /**
     * Read file array list.
     *
     * @return the array list
     */
    public ArrayList<String> readFile() {
        File file = new File("input.txt");
        ArrayList<String> words = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                words.add(st);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}
