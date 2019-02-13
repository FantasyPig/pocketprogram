package leetcode;

public class Leetcode151 {

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        int len = strings.length;
        int left = 0;
        int right = len - 1;
        String tmp;
        while (left < right) {
            tmp = strings[left];
            strings[left] = strings[right];
            strings[right] = tmp;
            ++left;
            --right;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (strings[i].length() == 0) {
                continue;
            }
            if (i < len - 1) {
                sb.append(strings[i].trim()).append(" ");
            } else {
                sb.append(strings[i].trim());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "  a  b";
        System.out.println(reverseWords(s));
    }
}
