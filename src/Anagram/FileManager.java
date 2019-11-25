package Anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {

    public ArrayList<String> readFile() {
        File file = new File("C:\\Users\\vaibh\\Desktop\\MEng. Soft. Engg\\ENSF-593 and ENSF-594\\Programs\\LinkedListSorting\\src\\TextFiles\\input.txt");
        ArrayList<String> words = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                words.add(st);
                System.out.println(st);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }
}
