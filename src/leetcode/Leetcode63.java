package leetcode;

public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) {
            return 0;
        }
        Integer row = obstacleGrid.length;
        Integer col = obstacleGrid[0].length;
        int result[][] = new int[row][col];
        if (obstacleGrid[0][0] != 1) {
            result[0][0] = 1;
        }
        for (int i = 1; i < col; ++i) {
            if (obstacleGrid[0][i] == 1 || (i >= 1 && result[0][i - 1] == 0)) {
                result[0][i] = 0;
            } else {
                result[0][i] = 1;
            }
        }
        for (int i = 1; i < row; ++i) {
            if (obstacleGrid[i][0] == 1 || (i >= 1 && result[i - 1][0] == 0)) {
                result[i][0] = 0;
            } else {
                result[i][0] = 1;
            }
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[row - 1][col - 1];
    }
}
