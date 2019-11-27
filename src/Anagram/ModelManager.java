package Anagram;

public class ModelManager {
    private AnagramLinkedList [] wordList;
    private AnagramLinkedList myList;

    public AnagramLinkedList[] getWordList() {
        return wordList;
    }

    public ModelManager(){}

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

    //We assume that the provided linklist contains only one element.
    public void addLinkedList(AnagramLinkedList myList) {
        //If word list is empty
        if (initialiseArray()) {
            wordList[0] = myList;
            return;
        }

        //If wordlist is not empty, compare the the provided linklist with all the linklists present in wordlist and add to existing link list if anagram and return to call.
        for (int i = 0; i < getwordListSize(); i++) {
            if (wordList[i].isAnagram(myList.getHead())) {
                wordList[i].insertToEndOfList(myList.getHead());
                return;
            }
        }

        //If provided linklist is not anagram with any existing linklists in the wordlist, then resize the wordlist and add the provided link list to the wordlist
        AnagramLinkedList[] newWordList = new AnagramLinkedList[getwordListSize() + 1];
        for (int j = 0; j < getwordListSize(); j++) {
            newWordList[j] = wordList[j];
        }
        newWordList[newWordList.length - 1] = myList;
        wordList = newWordList;
        return;
    }

    public void printWordList(){
        for(int i=0;i<getwordListSize();i++){
            System.out.println(wordList[i]);
        }
    }

}



