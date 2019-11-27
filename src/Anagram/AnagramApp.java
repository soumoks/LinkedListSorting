package Anagram;
import java.util.ArrayList;

/**
 * The type Anagram app.
 */
public class AnagramApp {

    private AnagramLinkedList wordLinkedList;
    private ModelManager theManager;

    public AnagramApp(){
        theManager = new ModelManager();
    }

    public static void main(String [] args) {
        FileManager fileManager = new FileManager();
        ArrayList<String> words = fileManager.readFile();
        AnagramApp app = new AnagramApp();
        for(String temp:words){
            app.wordLinkedList = new AnagramLinkedList(new Word(temp));
            app.theManager.addLinkedList(app.wordLinkedList);
        }
        app.theManager.printWordList();
    }
}
