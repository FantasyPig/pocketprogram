package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * N皇后问题
 */
public class Leetcode51 {

    public static List<List<String>> solveNQuees(int n) {
        List<List<String>> results = new LinkedList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        generateHang(col, pie, na, 0, n, new LinkedList<>(), results);
        return results;
    }

    public static void generateHang(Set<Integer> col, Set<Integer> pie, Set<Integer> na, int hang, int n, List<String> result, List<List<String>> results){
        if(hang >= n) {
            results.add(result);
            return;
        }
        for(int i = 0; i < n; ++i) {
            if(!col.contains(i) && !pie.contains(i + hang) && !na.contains(i - hang)) {
                col.add(i);
                pie.add(i + hang);
                na.add(i - hang);
                List<String> newList = new LinkedList<>();
                newList.addAll(result);
                newList.add(generateString(n, i));
                generateHang(col, pie, na, hang + 1, n, newList, results);
                col.remove(i);
                pie.remove(i + hang);
                na.remove(i - hang);
            }
        }
    }


    public static String generateString(int n, int index){
        StringBuffer sb = new StringBuffer();
        for(int i =0; i < n; ++i){
            if(i == index){
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solveNQuees(4));
    }





























}
