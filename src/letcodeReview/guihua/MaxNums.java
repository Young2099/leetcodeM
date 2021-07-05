package letcodeReview.guihua;

/**
 * 相邻不选择的最大和
 *
 */
public class MaxNums {
    public static void main(String[] args) {
        int[]  nums = new int[]{1,2,4,1,7,8,3};
        int a = new MaxNums().dp_opt(nums);
        System.out.println(a);
    }
    public int rec_opt(int[] nums, int index){
        if (index == 0){
            return nums[0];
        }else if (index ==1){
            return Math.max(nums[0],nums[1]);
        }else {
            return Math.max((rec_opt(nums,index-2) + nums[index]),(rec_opt(nums,index-1)));
        }
    }

    /**
     * 动态规划，不递归
     * @param nums
     * @return
     */
    public int dp_opt(int[] nums){
        int[] temp = new int[nums.length];
        temp[0]  = nums[0];
        temp[1]  = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            temp[i] = Math.max((temp[i-2]+ nums[i]),(temp[i-1]));
        }
        return temp[temp.length-1];
    }
}
