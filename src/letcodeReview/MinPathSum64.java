package letcodeReview;

public class MinPathSum64 {
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int gird[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int sum = getMinPath3(gird);
        System.out.println(sum);
    }

    private static int minPathSum(int[][] gird) {
        int m = gird.length;
        int n = gird[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    gird[i][j] = gird[i][j] + gird[i][j - 1];
                } else if (i != 0 && j == 0) {
                    gird[i][j] = gird[i][j] + gird[i - 1][j];
                } else if (i != 0 && j != 0) {
                    gird[i][j] = gird[i][j] + Math.min(gird[i][j - 1], gird[i - 1][j]);
                }
            }
        }
        return gird[m - 1][n - 1];
    }

    public static int getMinPath2(int[][] gird) {
        int m = gird.length;
        int n = gird[0].length;
        int[] dp = new int[n];
        dp[0] = gird[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[j] = gird[i][j] + dp[j - 1];
                } else if (i != 0 && j == 0) {
                    dp[j] = gird[i][j] + dp[j];
                } else if (i != 0 && j != 0) {
                    dp[j] = gird[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 递归
     *
     * @param gird
     * @return
     */
    public static int getMinPath3(int[][] gird) {
        int[][] dp = new int[][]{{0, 1}, {1, 0}};
        int sum = gird[0][0];
        dfs(gird, dp, 0, 0, sum);
        return minPath;
    }

    private static int minPath = Integer.MAX_VALUE;

    private static void dfs(int[][] gird, int[][] dp, int row, int col, int sum) {
        if (row == gird.length - 1 && col == gird[0].length - 1) {
            minPath = Math.min(minPath, sum);
            return;
        }
        for (int[] dir : dp) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0 ||
                    nextCol > gird.length - 1 || nextRow > gird[0].length - 1)
                continue;
            sum += gird[nextRow][nextCol];
            dfs(gird, dp, nextRow, nextCol, sum);
            sum -= gird[nextRow][nextCol];
        }

    }
}
