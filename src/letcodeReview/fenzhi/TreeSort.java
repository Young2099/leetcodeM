package letcodeReview.fenzhi;

import java.util.Arrays;

public class TreeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 1, 0, 7, 3, 9};
        TreeSort t = new TreeSort();
        t.tree_sort(nums, nums.length);
        for (int a :
              nums) {
            System.out.println(a);
        }
    }

    public void heapfiy(int[] nums, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int min = i;
        if (c1 < n && nums[c1] < nums[min]) {
            min = c1;
        }
        if (c2 < n && nums[c2] < nums[min]) {
            min = c2;
        }
        if (min != i) {
            swapInt(nums, i, min);
            heapfiy(nums,n,min);
        }
    }

    private void swapInt(int[] nums, int i, int min) {
        int temp = nums[i];
        nums[i] = nums[min];
        nums[min] = temp;
    }

    private void build_heap(int[] nums, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) >> 1;
        for (int i = parent; i >= 0; i--) {
            heapfiy(nums, n, i);
        }
    }

    private void tree_sort(int[] nums, int n) {
        build_heap(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            swapInt(nums, i, 0);
            heapfiy(nums, i, 0);
        }
    }
}
