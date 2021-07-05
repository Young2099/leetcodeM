package letcodeReview.fenzhi;

public class HeapTreeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 6, 4};
        mergeSort(nums, 0, nums.length - 1);
        for (int a :
                nums) {
            System.out.println(a);
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int start1 = left;
        int start2 = mid + 1;
        int index = 0;
        int[] temp = new int[right - left + 1];
        while (start1 <= mid && start2 <= right) {
            temp[index++] = nums[start1] <= nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= mid) {
            temp[index++] = nums[start1++];
        }
        while (start2 <= right) {
            temp[index++] = nums[start2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }

    }
}
