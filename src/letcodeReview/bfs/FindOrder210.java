package letcodeReview.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder210 {

    public static void main(String[] args) {
        new FindOrder210().findOrder(6, new int[][]{{5, 3}, {5, 4}, {3, 0}, {3, 1}, {4, 1}, {4, 2}});

    }


    public boolean findOrder(int numCourses, int[][] prerequisites) {
        int[] flags = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
        }
        return false;
    }



}
