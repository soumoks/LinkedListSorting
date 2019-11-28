package Anagram;

public class ModelManager {
    private AnagramLinkedList [] wordList;

    public AnagramLinkedList[] getWordList() {
        return wordList;
    }

    public ModelManager(){}

    /**
     * Returns the lenght of the wordList array
     * @return
     */
    public int getwordListSize(){
        return wordList.length;
    }

    /**
     * Initialises an array if it is null and returns True.
     * Returns False otherwise
     * @return
     */
    public Boolean initialiseArray(){
        if(wordList == null){
            wordList = new AnagramLinkedList[1];
            return true;
        }
        return false;
    }

    /**
     * Adds the provided linked list to the worslist Array. This function also checks if the provided linked consists of a word that is an anagram with any of the existing words
     * in the wordlist, adds the provided linked list in order with the existing linked list.
     * Here, we assume that the provided linklist contains only one element.
     * @param myList
     */
    public void addLinkedList(AnagramLinkedList myList) {
        //If word list is empty
        if (initialiseArray()) {
            wordList[0] = myList;
            return;
        }

        //If wordlist is not empty, compare the the provided linklist with all the linklists present in wordlist and add to existing link list if anagram and return to calling function.
        for (int i = 0; i < getwordListSize(); i++) {
            if (wordList[i].isAnagram(myList.getHead())) {
                wordList[i].insertInOrder(myList.getHead());
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

    int partition(AnagramLinkedList arr[], int low, int high)
    {
        AnagramLinkedList pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j].getHead().getWordName().compareTo(pivot.getHead().getWordName()) < 0)
            {
                i++;

                // swap arr[i] and arr[j]
                AnagramLinkedList temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        AnagramLinkedList temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(AnagramLinkedList arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }




}



