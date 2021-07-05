package letcodeReview.fenzhi;

import java.util.Random;

public class FindKThLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2, 6};
        findKthLargest(nums, 3);
        for (int a
                :
                nums
        ) {
            System.out.print(a);

        }
    }

    static Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
//        mergeSort(nums.length, 0, nums.length - 1);
        tree_sort(nums, nums.length);
        return 0;
    }

    private static void mergeSort(int length, int left, int right) {

    }

    public static void tree_sort(int[] nums, int n) {
        build_heap(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapfiy(nums, 0,i);
        }
    }


    public static void build_heap(int[] nums, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) >> 1;
        for (int i = parent; i >= 0; i--) {
            heapfiy(nums, i, n);
        }
    }

    /**
     * 三个节点堆的排序
     *
     * @param nums
     * @param i
     * @param n
     */
    public static void heapfiy(int[] nums, int i, int n) {
        if (i >= n) {
            return;
        }
        int c1 = (i << 1) + 1;
        int c2 = (i << 1) + 2;
        int max = i;
        if ( c1 < n && nums[c1] < nums[max] ) {
            max = c1;
        }
        if (c2 < n && nums[c2] < nums[max] ) {
            max = c2;
        }
        if (max != i) {
            swap(nums, i, max);
            heapfiy(nums, max, n);
        }
    }

    public static void swap(int[] nums, int i, int max) {
        int temp = nums[i];
        nums[i] = nums[max];
        nums[max] = temp;
    }

}
