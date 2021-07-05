package letcodeReview.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumIslands {

    public static void main(String[] args) {
        NumIslands islands = new NumIslands();
        char[][] chars = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'O', '0', '0', '0', '0'}};
        int size = islands.numIslands2(chars);
        System.out.printf("-----" + size);
    }

    /**
     * 深度优先
     *
     * @param chars
     * @return
     */
    private int numIslands2(char[][] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == '1') {
                    dfs2(chars, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private void dfs2(char[][] chars, int i, int j) {
        if (i >= 0 && i <= chars.length - 1 && j >= 0 && j <= chars[0].length - 1 && chars[i][j] == '1') {
            chars[i][j] = '0';
            dfs2(chars, i + 1, j);
            dfs2(chars, i - 1, j);
            dfs2(chars, i, j + 1);
            dfs2(chars, i, j - 1);
        }
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;

    }


    /**
     * 深度优先
     *
     * @param gird
     * @param i
     * @param j
     */
    private void dfs(char[][] gird, int i, int j) {
        if (i >= 0 && i <= gird.length - 1 && j >= 0 && j <= gird[0].length - 1 && gird[i][j] == '1') {
            gird[i][j] = '0';
            dfs(gird, i + 1, j);
            dfs(gird, i - 1, j);
            dfs(gird, i, j + 1);
            dfs(gird, i, j - 1);
        }

    }


}
