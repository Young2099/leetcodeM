package letcodeReview;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicatefindDuplicate287 {
    private static int a;

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
//        quickSort(nums, 0, nums.length - 1);
//        int b = findDuplicate(nums);
//        System.out.println(b);
        tree_node(nums,nums.length);

        for (int a : nums){
            System.out.println(a);
        }

    }

    public static int findDuplicate1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return 0;
    }

    public static void heapfiy(int[] nums, int n, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int min = i;
        if (left < n && nums[left] < nums[min]) {
            min = left;
        }
        if (right < n && nums[right] < nums[min]) {
            min = right;
        }
        if (min != i) {
            swap(nums, min, i);
            heapfiy(nums, n, min);
        }
    }
    public static void tree_node(int[] nums, int n) {
        build_heap(nums, n);
        for (int i = n - 1; i >= 0; i--) {

            swap(nums, 0, i);
            heapfiy(nums, i, 0);

        }
    }

    public static void build_heap(int[] nums, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >=0; i--) {
            heapfiy(nums,n,i);
        }
    }

    private static void swap(int[] nums, int min, int i) {
        int temp = nums[min];
        nums[min] = nums[i];
        nums[i] = temp;
    }


    public static int findDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
            } else {
                return num;
            }
        }
        return -1;
    }



    public static void quickSort(int[] num, int left, int right) {
        if (left > right) {
            return;
        }
        int mindex = getMinIndex(num, left, right);
        quickSort(num, left, mindex - 1);
        quickSort(num, mindex + 1, right);

    }

    private static int getMinIndex(int[] num, int left, int right) {
        int i = left;
        int j = right;
        int middle = num[i];
        while (i < j) {
            while (i < j && num[j] >= middle) {
                if (num[j] == middle) {
                    a = middle;
                }
                j--;
            }
            num[i] = num[j];
            while (i < j && num[i] <= middle) {
                if (num[i] == middle) {
                    a = middle;
                }
                i++;
            }
            num[j] = num[i];
        }
        num[i] = middle;
        return i;
    }
}
