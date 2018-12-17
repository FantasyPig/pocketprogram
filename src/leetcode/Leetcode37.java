package leetcode;

/**
 * 解数独
 */
public class Leetcode37 {

    public static boolean solveSudoku(char[][] board) {
        int size = 9;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j] == '.') {
                    for (int c = 0; c < size; ++c) {
                        if (isValid(board, i, j, (char) c)) {
                            board[i][j] = (char) c;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        int size = 9;
        for (int i = 0; i < size; ++i) {
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row + i / 3][col + i % 3] != '.'
                && board[row + i / 3][col + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

}
