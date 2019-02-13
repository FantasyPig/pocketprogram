package leetcode;

public class Leetcode69 {

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if ( x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (x /mid == mid) {
                return mid;
            } else if (mid < x / mid) {
                if (mid + 1 <= x && (mid + 1) >x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (mid >= 2 && (mid - 1)< x / (mid - 1)) {
                    return mid - 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
