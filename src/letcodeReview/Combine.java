package letcodeReview;

import java.util.*;

public class Combine {
    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        dfs(n, k,1, list,temp);
        return list;
    }

    private static void dfs(int n, int k,int index, List<List<Integer>> res, ArrayDeque<Integer> temp) {
        if (temp.size() == k){
            res.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.addLast(i);
            dfs(n,k,i+1,res,temp);
            temp.removeLast();
        }
    }
}
