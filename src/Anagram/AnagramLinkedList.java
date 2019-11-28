package Anagram;

import java.util.Arrays;

public class AnagramLinkedList {
    private Word head;

    public Word getHead(){
        return head;
    }

    public void setHead(Word head) {
        this.head = head;
    }

    public AnagramLinkedList(){
        setHead(null);
    }

    public AnagramLinkedList(Word myWord){
        setHead(myWord);
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
            temp = temp + " ";
            cursor = cursor.getNext();
        }
        return temp;
    }

    public boolean isAnagram(Word w) {
        Word cursor = head;
        boolean isAnagram = false;

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
        return isAnagram;
    }

    /**
     * Gets the previous node in the linked list given the provided node.
     * @param w
     * @return
     */
    public Word getPreviousNode(Word w) {
        Word cursor = head;
        Word toReturn = null;
        while (cursor.getNext() != null) {
            if (cursor.getNext() == w) {
                toReturn = cursor;
            }
            cursor = cursor.getNext();
        }
        return toReturn;
    }

    public void insertInOrder(Word w) {
        Word cursor = head;
        Word temp = null;
        Word prev = null;
        //Head case - If the provided word is less than the head
        if (size() == 1) {
            if (cursor.getWordName().compareTo(w.getWordName()) > 0) {
                insertToFrontOfList(w);
                return;
            } else {
                insertToEndOfList(w);
                return;
            }
        }
        while (cursor.getNext() != null) {
            if (cursor.getWordName().compareTo(w.getWordName()) > 0) {
                if (cursor == head) {
                    insertToFrontOfList(w);
                    return;
                } else {
                    prev = getPreviousNode(cursor);
                    prev.setNext(w);
                    w.setNext(cursor);
                    return;
                }
            }
            cursor = cursor.getNext();
        }
        if (cursor.getWordName().compareTo(w.getWordName()) > 0) {
            prev = getPreviousNode(cursor);
            prev.setNext(w);
            w.setNext(cursor);
        } else {
            insertToEndOfList(w);
        }
    }
}
