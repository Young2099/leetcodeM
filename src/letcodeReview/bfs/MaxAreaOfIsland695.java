package letcodeReview.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland695 {


    public static void main(String[] args) {
       MaxAreaOfIsland695 maxAreaOfIsland695 =  new MaxAreaOfIsland695();
       int a = maxAreaOfIsland695.maxAreaOfIsland(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        System.out.println(a);

    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i, j - 1);
        num += dfs(grid, i, j + 1);
        return num;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int i, int j) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;
        int area = 1;
        while(!queue.isEmpty()){
            int[] x = queue.poll();
            for(int index = 0; index < 4; index++){
                int nx = x[0] + dx[index], ny = x[1] + dy[index];
                if(nx>=0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                    grid[nx][ny] = 0;
                    area += 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return area;
    }


}
