package Anagram;

import java.util.ArrayList;

public class AnagramLinkedList {
    private Word head;
    private Word [] wordList;

    public Word getHead() {
        return head;
    }

    public void setHead(Word head) {
        this.head = head;
    }

    public AnagramLinkedList(){
        setHead(null);
        //wordList = new Word[];
    }

    public void insertToFrontOfList(Word w){
        if(head == null){
            setHead(w);
        }
        else{
            w.setNext(head);
            head = w;
        }
    }

    public void insertToEndOfList(Word w){
        if(head == null){
            setHead(w);
        }
        else{
            getLastNode().setNext(w);
        }
    }

    public Word getLastNode(){
        Word cursor = head;
        while(cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        return cursor;
    }

    private int size(){
        Word cursor = head;
        int counter = 0;
        while(cursor.getNext() != null){
            counter++;
            cursor = cursor.getNext();
        }
        counter++;
        return counter;
    }


}
