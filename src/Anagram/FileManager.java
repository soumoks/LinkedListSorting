package Anagram;

import java.io.*;
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
    public AnagramLinkedList readFile(String filename) {
        File file = new File(filename);
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

    public void writeDataToFile(AnagramLinkedList[] arr, String filename) {
        try (FileWriter writer = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for(int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
