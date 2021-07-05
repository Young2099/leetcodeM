package letcodeReview;

public class SearchInsert35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int a = searchInsert(nums, 7);
        System.out.println(a);
    }

    public static int searchInsert(int[] nums, int target) {
        return dfsLeft(0, nums.length - 1, nums, target);
    }

    public static int dfsLeft(int left, int right, int[] nums, int target) {
        int mindIndex = 0;
        while (left <= right) {
            mindIndex = (right - left) / 2 + left;
            if (nums[mindIndex] == target) return mindIndex;
            if (target < nums[mindIndex]) right = mindIndex - 1;
            else left = mindIndex + 1;

        }
        return right+1;

    }
}
