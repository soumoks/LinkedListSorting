package Anagram;
import java.util.ArrayList;

/**
 * The type Anagram app.
 */
public class AnagramApp {

    private AnagramLinkedList wordLinkedList;
    private ModelManager theManager;
    long startTime, endTime = 0;

    public AnagramApp(){
        theManager = new ModelManager();
    }

    public static void main(String [] args) {
        FileManager fileManager = new FileManager();
        AnagramApp app = new AnagramApp();
        app.startTime = System.nanoTime();
        AnagramLinkedList words = fileManager.readFile();

        Word cursor = words.getHead();
        System.out.println("Words from text file: \n");
        while(cursor != null){
            System.out.println(cursor.getWordName());
            app.wordLinkedList = new AnagramLinkedList(new Word(cursor.getWordName()));
            app.theManager.addLinkedList(app.wordLinkedList);
            cursor = cursor.getNext();
        }
        //app.theManager.printWordList();
        app.theManager.sort(app.theManager.getWordList(),0,app.theManager.getwordListSize() -1);
        app.endTime = System.nanoTime();
        System.out.println();
        System.out.println("Sorted list of anagrams: ");
        app.theManager.printWordList();
        long duration = app.calculateDuration(app.startTime, app.endTime);
        System.out.println("\nTime required to process input file: " + duration);
    }

    public long calculateDuration(long startTime, long endTime){
        return endTime - startTime;
    }
}
