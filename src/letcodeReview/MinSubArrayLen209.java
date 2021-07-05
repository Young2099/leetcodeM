package letcodeReview;

import java.util.Arrays;
import java.util.Map;

public class MinSubArrayLen209 {
    public static void main(String[] args) {
        int a = minSubArrayLen(213, new int[]{
                12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12});
        System.out.println(a);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
