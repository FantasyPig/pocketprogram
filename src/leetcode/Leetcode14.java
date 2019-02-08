package leetcode;

public class Leetcode14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int number = strs.length;
        String[] results = new String[number];
        for (int i = 0; i < number; ++i) {
            if (i ==0) {
                results[i] = strs[i];
            } else {
                results[i] = commonString(results[i - 1], strs[i]);
            }
        }
        return results[number - 1];
    }

    private static String commonString(String s1, String s2) {
        int len = Integer.min(s1.length(), s2.length());
        String commonString = "";
        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }
        for (int i = 0; i < len; ++i) {

            if (s1.charAt(i) != s2.charAt(i)) {
                return commonString;
            } else {
                commonString += s1.charAt(i);
            }
        }
        return commonString;
    }

    public static void main(String[] args) {
        String[] s = {"caa","","a","acb"};
        System.out.println(longestCommonPrefix(s));
    }
}
