package letcodeReview.bfs;

import java.util.*;

public class CanFinish207 {
    public static void main(String[] args) {
        CanFinish207 canFinish207 = new CanFinish207();
//        boolean a = canFinish207.canFinish(6, new int[][]{{5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}});
//        System.out.println(a);
        boolean a =  canFinish207.canFinish(6,new int[][]{{5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}});
        System.out.println(a);
    }

    /**
     * 广度？？？bfs？？
     * @param numCourses
     * @param prerequisites
     * @return   {5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            //得到入度，[5,3] 3必须在5之前读，所以入度为1，而统计pre二维数组的首位就可以得到每个数字的在图中的入度，而pre[1]就可以得到出度
            indegree[pre[0]]++;
            System.out.println(pre[0]);
        }
        //put course with indegree = 0 to dueque
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        //execute the course
        int i = 0;
        while (!queue.isEmpty()){
            Integer curr = queue.poll();
            res[i++] = curr;
            //remove the pre = curr;
            for (int[] pre : prerequisites) {
                if(pre[1] == curr){
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0){
                        queue.offer(pre[0]);
                    }
                }

            }
        }
        return i == numCourses;

    }

    /**
     * {5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adj.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] flags, int i) {
        //if(flags[i] == 1) return false;  //先判断再修改标志位
        //if(flags[i] == -1) return true;  //别的dfs路径访问过了，我不需要访问了
        //flags[i] = 1;   //只有这个标志位是干净的，别人还没有动过，我才能标记为1，说明本次dfs我遍历过它
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adj.get(i)) {
            if (!dfs(adj, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }

}
