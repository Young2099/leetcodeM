package letcodeReview.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish207_1 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}};
//        int[][] nums = new int[][]{{1, 0}, {0, 1}};
        boolean a = new CanFinish207_1().canFinish(6, nums);
        System.out.println(a);

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flags = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(list, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> list, int[] flags, int i) {
        /*if(flags[i] == 1) return false;  //先判断再修改标志位
if(flags[i] == -1) return true;  //别的dfs路径访问过了，我不需要访问了
flags[i] = 1;   //只有这个标志位是干净的，别人还没有动过，我才能标记为1，说明本次dfs我遍历过它*/
        if (flags[i] == 1) return false;
        if (flags[i] == 2) return true;
        flags[i] = 1;
        for (Integer j : list.get(i)) {
            if (!dfs(list, flags, j)) return false;
        }
        flags[i] = 2;
        return true;
    }
    /**
     * //        int[][] nums = new int[][]{{5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}};
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            //计算各个位置上的入度
            indegress[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adj.get(pre)) {
                if (--indegress[cur] == 0) queue.add(cur);
            }

        }
        return numCourses == 0;
    }


}
