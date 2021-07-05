package letcodeReview;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        int index = 0;
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        boolean[] booleans = new boolean[nums.length];
        dfs(temp, index, res, nums,booleans);

        return res;
    }

    private static void dfs(List<Integer> temp, int index, List<List<Integer>> res, int[] nums,boolean[] booleans) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i]){
                continue;
            }
            temp.add(nums[i]);
            booleans[i] = true;
            dfs(temp, i, res, nums,booleans);
            booleans[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
