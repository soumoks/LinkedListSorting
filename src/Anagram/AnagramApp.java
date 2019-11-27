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
        AnagramLinkedList words = fileManager.readFile();
        AnagramApp app = new AnagramApp();
        Word cursor = words.getHead();
        while(cursor != null) {
            app.wordLinkedList = new AnagramLinkedList(new Word(cursor.getWordName()));
            app.theManager.addLinkedList(app.wordLinkedList);
            cursor = cursor.getNext();
        }
        app.theManager.InsertionSort();
        app.theManager.printWordList();
    }
}
