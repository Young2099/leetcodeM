package sort;

public class ArraySort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6};
        new ArraySort().mergeSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(i, j, nums);
                }
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = getMiddle(nums, left, right);
        quickSort(nums, left, middle - 1);
        quickSort(nums, middle + 1, right);
    }

    private int getMiddle(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }


    public void tree_sort(int[] nums) {
        build_heap(nums, nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(0, i, nums);
            heapfiy(nums, i, 0);
        }
    }

    private void build_heap(int[] nums, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) >> 1;
        for (int i = parent; i >= 0; i--) {
            heapfiy(nums, n, i);
        }
    }

    public void heapfiy(int[] nums, int n, int i) {
        if (i >= n) {
            return;
        }
        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        int max = i;
        if (left < n && nums[left] > nums[max]) {
            max = left;
        }
        if (right < n && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(i, max, nums);
            heapfiy(nums, n, max);
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param low
     * @param high
     */
    public void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int start1 = low;
        int start2 = mid + 1;
        int k = 0;
        while (start1 <= mid && start2 <= high) {
            temp[k++] = arr[start1] <= arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= mid) {
            temp[k++] = arr[start1++];
        }
        while (start2 <= high) {
            temp[k++] = arr[start2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

    }


}
