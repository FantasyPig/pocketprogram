package pointToOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 斐波那契数列
 */
public class Question10 {

    /**
     * 输出数列第n项
     * @param n
     */
    public static void solve(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(cursion(map, n));
    }

    private static int cursion(Map<Integer, Integer> map, int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            Integer mapValue = map.get(n);
            if(mapValue != null) {
                return mapValue;
            }
            int result = cursion(map, n - 1) + cursion(map, n - 2);
            map.put(n, result);
            return result;
        }
    }

    public static int common(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            return common(n - 1) + common(n - 2);
        }
    }

    public static int shunxu(int n) {
        int[] result = {1,1};
        int now = 1;
        if(n == 1 || n == 2) {
            now = 1;
        }
        for(int i = 0; i < n; ++i) {
            if(i == 1 || i == 2) {
                continue;
            }
            now = result[0] + result[1];
            result[0] = result[1];
            result[1] = now;
        }
        return now;
    }

    public static void main(String[] args) {
        int n = 50;
//        long t1 = System.currentTimeMillis();
//        System.out.println(common(n));
//        long t2 = System.currentTimeMillis();
//        System.out.prin                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               2 - t1);
        long t3 = System.currentTimeMillis();
        solve(n);
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
        long t5 = System.currentTimeMillis();
        System.out.println(shunxu(n));
        long t6 = System.currentTimeMillis();
        System.out.println(t6 - t5);
    }

}
