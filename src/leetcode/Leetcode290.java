package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode290 {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "apple fish fish pear";
        System.out.println(wordPattern(pattern, str));
        ;
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        String tmpString;
        Character tmpChar;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; ++i) {
            tmpChar = pattern.charAt(i);
            tmpString = words[i];
            if (map1.get(tmpChar) == null) {
                map1.put(tmpChar, tmpString);
            } else {
                if (!map1.get(tmpChar).equals(tmpString)) {
                    return false;
                }
            }
            if (map2.get(tmpString) == null) {
                map2.put(tmpString, tmpChar);
            } else {
                if (!map2.get(tmpString).equals(tmpChar)) {
                    return false;
                }
            }
        }

        return true;
    }
}
