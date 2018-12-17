package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode22 {

    public static List<String> generateParenthesis(int n){
        List<String> result = new LinkedList<>();
        generate(1, 0, n, result, "(");
        return result;
    }

    public static void generate(int left, int right, int n, List result, String tmp){
        if(left == n && right == n){
            result.add(tmp);
            return;
        }
        if(left < n){
            generate(left + 1, right, n, result, tmp + "(");
        }
        if(left > right && right < n){
            generate(left, right + 1, n, result, tmp + ")");
        }
    }

    public static void main(String[] args){
        System.out.println(Leetcode22.generateParenthesis(3));
    }


}
