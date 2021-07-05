package letcodeReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets78 {
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> temp = new Stack<>();
        dfs(res,temp,0,nums);
        return res;
    }

    public static void dfs(List<List<Integer>> res, Stack<Integer> temp, int index, int[] nums){
        System.out.println(temp);
        res.add(new ArrayList<>(temp));
        for (int j = index; j < nums.length; j++) {
            temp.add(nums[j]);
            dfs(res,temp,j+1,nums);
            temp.pop();
        }
    }


}
