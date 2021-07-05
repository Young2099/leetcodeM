package letcodeReview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int a = removeElement(nums, 2);

        System.out.println(a);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    private static int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }

        }
        return j;
    }

    private static int removeElement(int[] nums, int val) {
        int left = 0;
        int n = nums.length;
        while (left < n) {
            if (nums[left] == val) {
                nums[left] = nums[n - 1];
                n--;
            } else {
                left++;
            }
        }
        return left;
    }
}
