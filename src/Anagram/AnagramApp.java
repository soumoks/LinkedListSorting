package Anagram;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The type Anagram app.
 */
public class AnagramApp {

    private AnagramLinkedList wordLinkedList;
    private ModelManager theManager;

    public AnagramApp(){
        wordLinkedList = new AnagramLinkedList();
        theManager = new ModelManager();
    }

    public static void main(String [] args) {
        //AnagramLinkedList theLinkedList = new AnagramLinkedList();
        FileManager fileManager = new FileManager();
        ArrayList<String> words = fileManager.readFile();
        AnagramApp app = new AnagramApp();
        app.addWordToNode(words);
//        app.areAnagram(words);
//        app.theManager.printWordList();
    }

    public void addWordToNode(ArrayList<String> words){
        for(String temp:words){
            //AnagramLinkedList anagramLinkedList = new AnagramLinkedList();
            wordLinkedList.addNode(new Word(temp));
        }
    }


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
                    //wordLinkedList.insertToFrontOfList(new Word(str1));
                    //wordLinkedList.insertToFrontOfList(new Word(str2));
                    //words.remove(str2);
                    //temp.add()
                    AnagramLinkedList anagramLinkedList = new AnagramLinkedList();
                    //anagramLinkedList.insertToFrontOfList(new Word(str1));
                    anagramLinkedList.insertToFrontOfList(new Word(str2));
                    words.remove(str2);
                    theManager.AddLinkedList(anagramLinkedList);
                    //System.out.println("Anagram words: " + str1 + " " + str2);
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
