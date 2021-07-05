package sort;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.reflect.generics.tree.Tree;

/**
 * 堆排序
 */
public class TreeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 10, 8, 9};
        new TreeSort().tree_map(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void heapfiy(int[] nums, int i, int n) {
        if (i >= n) {
            return;
        }
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < n && nums[c1] > nums[max]) {
            max = c1;
        }
        if (c2 < n && nums[c2] > nums[max]) {
            max = c2;
        }
        if (max != i) {
            swap(nums, i, max);
            heapfiy(nums, max, n);
        }

    }

    public void build_heap(int[] nums, int n) {
        int last_node = n - 1;
        int last_parent = last_node / 2;
        for (int i = last_parent; i >= 0; i--) {
            heapfiy(nums, i, n);
        }
    }

    public void tree_map(int[] nums, int n) {
        build_heap(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapfiy(nums, 0, i);
        }
    }

    public void swap(int[] nums, int i, int max) {
        int temp = nums[i];
        nums[i] = nums[max];
        nums[max] = temp;
    }
}
