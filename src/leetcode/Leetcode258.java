package leetcode;

public class Leetcode258 {
    public static void main(String[] args) {
        Integer i = 1234;
    }

    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 9) {
                sum +=num - num / 10 * 10;
                num = num / 10;
            }
            sum += num;
            num = sum;
        }
        return num;
    }
}
