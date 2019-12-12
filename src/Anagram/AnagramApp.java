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
        if(args.length > 0){
            app.startTime = System.nanoTime();
            AnagramLinkedList words = fileManager.readFile(args[0]);
            app.endTime = System.nanoTime();
            long duration1 = app.calculateDuration(app.startTime, app.endTime);
            Word cursor = words.getHead();
            //System.out.println("Words from text file: \n");
            app.startTime = System.nanoTime();
            while(cursor != null){
                //System.out.println(cursor.getWordName());
                app.wordLinkedList = new AnagramLinkedList(new Word(cursor.getWordName()));
                app.theManager.addLinkedList(app.wordLinkedList);
                cursor = cursor.getNext();
            }
            app.endTime = System.nanoTime();
            long duration2 = app.calculateDuration(app.startTime, app.endTime);
            //app.theManager.printWordList();
            app.startTime = System.nanoTime();
            app.theManager.sort(app.theManager.getWordList(),0,app.theManager.getwordListSize() -1);
            app.endTime = System.nanoTime();
            long duration3 = app.calculateDuration(app.startTime, app.endTime);
            System.out.println();
            System.out.println("Sorted list of anagrams: ");
            app.theManager.printWordList();
            fileManager.writeDataToFile(app.theManager.getWordList(),args[1]);
            System.out.println("\nNumber of words: " + words.size());
            System.out.println("\nTime required to load input data: " + duration1);
            System.out.println("\nTime required to Compare words and add to Linked List: " + duration2);
            System.out.println("\nTime required to sort the LinkedList array using quick sort: " + duration3);
            long totalTime = duration1 + duration2 + duration3;
            System.out.println("Total Time required is: " + totalTime);
        }
    }

    public long calculateDuration(long startTime, long endTime){
        return endTime - startTime;
    }
}
