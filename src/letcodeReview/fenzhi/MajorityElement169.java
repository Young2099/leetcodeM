package letcodeReview.fenzhi;


public class MajorityElement169 {
    public static void main(String[] args) {
        int a = majorityElement1(new int[]{2, 2, 1, 1, 1});
        System.out.println(a);

    }

    private static int majorityElement1(int[] nums) {
        int ans = nums[0], len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                len++;
            } else {
                if (len > 0) {
                    len--;
                } else {
                    ans = nums[i];
                    len = 1;
                }
            }
        }
        return ans;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = lo + ((hi - lo) >> 1);
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}