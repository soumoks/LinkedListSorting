package Anagram;

import java.util.ArrayList;
import java.util.Arrays;

public class AnagramApp {
    public static void main(String [] args) {
        FileManager fileManager = new FileManager();
        ArrayList<String > words = fileManager.readFile();
        AnagramApp app = new AnagramApp();
        app.areAnagram(words);
    }

    public boolean areAnagram(ArrayList<String> words) {
        for(int i = 0; i < words.size(); i++) {
            String str1 = words.get(i);
            for(int j = i + 1; j < words.size(); j ++) {
                String str2 = words.get(j);
                if(str1.length() != str2.length()) {
                    //TODO:
                }
                char[] c1 = str1.toCharArray();
                char[] c2 = str2.toCharArray();
                Arrays.sort(c1);
                Arrays.sort(c2);

                boolean value = isAnagram(c1, c2);
                if(value) {

                    System.out.println("Anagram words: " + str1 + " " + str2);
                }
            }
        }
        return true;
    }

    public boolean isAnagram(char[] str1, char[] str2) {
        for (int k = 0; k < str1.length; k++) {
            if(str1[k] != str2[k]) {
                return false;
            }
        }
        return true;
    }
}
