package letcodeReview.guihua;

public class FindNum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 1, 7, 8, 3};
       boolean a =  new FindNum().findNum(nums,nums.length-1,3);
        System.out.println(a);
    }

    public boolean findNum(int[] nums, int i, int s) {
        if (s == 0) {
            return true;
        } else if (i == 0) {
            return nums[0] == s;
        } else if (nums[i] > s) {
            return findNum(nums, i - 1, s);
        } else {
            boolean A = findNum(nums, i - 1, s - nums[i]);
            boolean B = findNum(nums, i - 1, s);
            return (A || B);
        }

    }


}
