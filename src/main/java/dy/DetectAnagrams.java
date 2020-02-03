package dy;/*
# Anagram

Write a program that, given a word and a list of possible anagrams, selects the correct sublist.

Given `"listen"` and a list of candidates like `"enlists" "google"
"inlets" "banana"` the program should return a list containing
`"inlets"`.
*/

import java.util.Arrays;

public class DetectAnagrams {

    public String[] detect(String target, String input) {
        String[] inputStrings=input.split(" ");

        char[] targetCharArray = target.toLowerCase().toCharArray();
        Arrays.sort(targetCharArray);
        String targetString = Tool.charArrayToString(targetCharArray);

        String[] anagrams = new String[inputStrings.length];
        int i = 0;
        for (String s : inputStrings) {
            if (s.equalsIgnoreCase(target)) {
                continue;
            }
            if (s.length() != target.length()) {
                continue;
            }

            char[] charArray = s.toLowerCase().toCharArray();
            Arrays.sort(charArray);

            if (targetString.equals(Tool.charArrayToString(charArray))) {
                anagrams[i++] = s;
            }
        }

        String[] result = new String[i];
        System.arraycopy(anagrams, 0, result, 0, i);

        return result;
    }
}
