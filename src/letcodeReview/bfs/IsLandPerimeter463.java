package letcodeReview.bfs;

import com.sun.glass.ui.Size;

import java.util.Arrays;

public class IsLandPerimeter463 {

    public static void main(String[] args) {
        IsLandPerimeter463 isLandPerimeter463 = new IsLandPerimeter463();
        isLandPerimeter463.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
    }

    public int isLandPerimeter1(int[][] grid) {
        int land = 0;
        int repeatLand = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    if (i < grid.length - 1 && grid[i][j] == grid[i + 1][j]) {
                        repeatLand++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j] == grid[i][j + 1]) {
                        repeatLand++;
                    }
                }
            }
        }
        return land * 4 - repeatLand * 2;
    }

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (!(r >= 0 && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);

    }


}
