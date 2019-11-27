package Anagram;

import java.util.ArrayList;
import java.util.Arrays;

public class AnagramLinkedList {
    private Word head;
    ModelManager manager = new ModelManager();

    private Word getHead(){
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
        while(cursor != null && cursor.getNext() != null){
            counter++;
            cursor = cursor.getNext();
        }
        counter++;
        return counter;
    }

    public String toString(){
        Word cursor = head;
        String temp = "";
        while(cursor != null){
            temp = temp + cursor;
            cursor = cursor.getNext();
        }
        return temp;
    }

    public boolean isAnagram(Word w) {
        Word cursor = head;
        boolean isAnagram = false;
//        if(w.getWordName().length() != cursor.getWordName().length()){
//            return false;
//        }
        while(cursor != null){
            char[] c1 = cursor.getWordName().toCharArray();
            char[] c2 = w.getWordName().toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            for (int k = 0; k < c1.length; k++) {
                if(c1[k] != c2[k]) {
                    return false;
                }
                isAnagram = true;
            }
        }
        return isAnagram;
    }

    public void addNode(Word w){
        for (AnagramLinkedList anagramLinkedList : manager.getWordList()) {
            if(anagramLinkedList == null){

            }
              if(anagramLinkedList.isAnagram(w)) {
                  anagramLinkedList.insertToEndOfList(w);
              } else {
                  AnagramLinkedList myList = new AnagramLinkedList();
                  myList.setHead(w);
                  manager.AddLinkedList(myList);
              }
        }

//        else {
//            if(isAnagram(w)) {
//                Word cursor = head;
//                while(cursor != null){
//                    myList.insertToEndOfList(w);
//                    cursor = cursor.getNext();
//                }
//            } else {
//                AnagramLinkedList newList = new AnagramLinkedList();
//                newList.setHead(w);
//            }
//            manager.AddLinkedList(myList);
//        }
    }
}
