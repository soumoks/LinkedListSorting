package Controller;

import Anagram.AnagramLinkedList;

public class Controller {
    private AnagramLinkedList wordList;

    public Controller(AnagramLinkedList wordList){
        this.wordList = wordList;
    }

    public AnagramLinkedList getWordList() {
        return wordList;
    }

    public void setWordList(AnagramLinkedList wordList) {
        this.wordList = wordList;
    }

}
