package Anagram;

public class Word {
    private String wordName;
    private Word next;

    public Word(){}

    public Word(String s){
        setWordName(s);
        setNext(null);
    }
    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public Word getNext() {
        return next;
    }

    public void setNext(Word next) {
        this.next = next;
    }

    public String toString(){
        return "Name: " + wordName;
    }
}
