package letcodeReview.fenzhi;

import java.util.*;

public class MaxSubArray53 {
    public static void main(String[] args) {
        int a = maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(a);
    }

    public static int maxSubArray(int[] nums) {
        int max = 0, sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            sum = Math.max(sum, max);

        }
        return sum;
    }

    public static int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int maxSubArray4(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }

    public static int maxSubArray3(int[] nums) {
        int res = Integer.MIN_VALUE;
        res = maxSubArrayHelper(nums, 0, nums.length - 1);
        return res;
    }

    /**
     * -2, 1, -3, 4, -1, 2, 1, -5, 4
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;
        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int midSum = findMaxCrossingSubarry(nums, left, mid, right);
        int result = Math.max(leftSum, rightSum);
        result = Math.max(result, midSum);
        return result;
    }

    private static int findMaxCrossingSubarry(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return (leftSum + rightSum);
    }

}
