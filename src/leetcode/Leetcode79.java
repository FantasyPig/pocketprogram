package leetcode;

public class Leetcode79 {

    public static boolean solution(char[][] board, String word) {
        if (board == null) {
            if (word == null) {
                return true;
            } else {
                return false;
            }
        }
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[] result = {false};
                    int[][] used = new int[row][col];
                    used[i][j] = 1;
                    cursion(i, j, word.substring(1), board, used, result);
                    if(result[0]) return true;
                }
            }
        }
        return false;
    }

    private static void cursion(int i, int j,String word, char[][] board, int[][] used,boolean[] result) {
        if(word.length() == 0) {
            result[0] = true;
            return;
        }
        char now = word.charAt(0);
        //up
        if (i > 0 && board[i - 1][j] == now && used[i - 1][j] != 1 ) {
            used[i - 1][j] = 1;
            cursion(i - 1, j, word.substring(1), board, used, result);
            used[i - 1][j] = 0;
        }
        //down
        if (i < board.length - 1 && board[i + 1][j] == now && used[i + 1][j] != 1) {
            used[i + 1][j] = 1;
            cursion(i + 1, j, word.substring(1), board, used, result);
            used[i + 1][j] = 0;
        }
        //left
        if (j > 0 && board[i][j - 1] == now && used[i][j - 1] != 1) {
            used[i][j - 1] = 1;
            cursion(i, j - 1, word.substring(1), board,used, result);
            used[i][j - 1] = 0;
        }
        //right
        if (j < board[0].length - 1 && board[i][j + 1] == now && used[i][j + 1] != 1) {
            used[i][j + 1] = 1;
            cursion(i, j + 1, word.substring(1), board, used, result);
            used[i][j + 1] = 0;
        }
    }


    public static void main(String[] args) {
        char[][] board = {{'z','z','h'},{'z','h','h'}};
        boolean a = solution(board, "zzhhhh");
        System.out.println(a);
    }
}
