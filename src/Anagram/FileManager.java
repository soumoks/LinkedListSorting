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
    public AnagramLinkedList readFile() {
        File file = new File("input.txt");
        AnagramLinkedList anagramLinkedList = new AnagramLinkedList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                anagramLinkedList.insertToEndOfList(new Word(st));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
        }
        return anagramLinkedList;
    }
}
