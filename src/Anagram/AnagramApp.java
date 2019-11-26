package Anagram;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The type Anagram app.
 */
public class AnagramApp {

    AnagramApp app = new AnagramApp();
    AnagramLinkedList wordLinkedList = new AnagramLinkedList();
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String [] args) {
        AnagramLinkedList theLinkedList = new AnagramLinkedList();
        Controller theController = new Controller(theLinkedList);
        theController.getWordList();
        FileManager fileManager = new FileManager();
        ArrayList<String> words = fileManager.readFile();
        AnagramApp app = new AnagramApp();
        app.areAnagram(words);
    }


    /**
     * Are anagram boolean.
     *
     * @param words the words
     * @return the boolean
     */
    public boolean areAnagram(ArrayList<String> words) {
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            String str1 = words.get(i);
            //String str2 = words.get(i+1);
            for(int j = i + 1; j < words.size(); j ++) {
                String str2 = words.get(j);
                if(str1.length() != str2.length()) {
                    //TODO:
                }
                char[] c1 = str1.toCharArray();
                char[] c2 = str2.toCharArray();
                Arrays.sort(c1);
                Arrays.sort(c2);

                boolean value = isAnagram(c1, c2);
                if(value) {
                    temp.add(str1);
                    temp.add(str2);
                    app.wordLinkedList.insertToFrontOfList(new Word(str1));
                    app.wordLinkedList.insertToFrontOfList(new Word(str2));
                    System.out.println("Anagram words: " + str1 + " " + str2);
                }
            }
        }
        return true;
    }


    /**
     * Is anagram boolean.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return the boolean
     */
    public boolean isAnagram(char[] str1, char[] str2) {
        for (int k = 0; k < str1.length; k++) {
            if(str1[k] != str2[k]) {
                return false;
            }
        }
        return true;
    }
}
