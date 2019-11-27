package Anagram;

import java.util.ArrayList;

public class ModelManager {
    private AnagramLinkedList [] wordList;
    private AnagramLinkedList myList;

    public AnagramLinkedList[] getWordList() {
        return wordList;
    }



    public ModelManager(){
        wordList = new AnagramLinkedList[1];
    }

    public int getwordListSize(){
        return wordList.length;
    }

    /**
     * Returns true if array is null
     * @return
     */
    public Boolean initialiseArray(){
        if(wordList == null){
            wordList = new AnagramLinkedList[1];
            return true;
        }
        return false;
    }

    public void AddLinkedList(AnagramLinkedList myList){
        initialiseArray();
        if(initialiseArray()){
            wordList[0] = myList;
        }
        else{
            AnagramLinkedList [] newWordList = new AnagramLinkedList[getwordListSize() + 1];
            for(int i=0;i<getwordListSize();i++){
                newWordList[i] = wordList[i];
            }
            newWordList[newWordList.length -1] = myList;
            wordList = newWordList;
        }
    }

//    public void addNode(Word w){
//        if(wordList == null){
//            myList = new AnagramLinkedList();
//            myList.insertToEndOfList(w);
//        }
//        else{
//            AnagramLinkedList list = new AnagramLinkedList();
//            list.addNode(w);
//        }
//            for(int i=0;i<getwordListSize();i++){
//                if(wordList[i].isAnagram(w)){
//                    wordList[i].insertToEndOfList(w);
//                }
//                else{
//
//                }
//        }
//        for(int i=0;i<getwordListSize();i++){
//            if(wordList[i].isAnagram(w)){
//                wordList[i].insertToEndOfList(w);
//            }
//            else{
//
//            }
//        }
//    }

    public void printWordList(){
        for(int i=0;i<getwordListSize();i++){
            System.out.println(wordList[i]);
        }
    }

}
