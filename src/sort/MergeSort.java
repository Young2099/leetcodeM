package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 2, 9, 4, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int start1 = low;
        int start2 = mid+1;
        int k = 0;
        while (start1 <= mid && start2 <= high){
            temp[k++] = nums[start1] < nums[start2] ? nums[start1++]:nums[start2++];
        }
        while (start1 <= mid){
            temp[k++]  = nums[start1++];
        }
        while (start2 <= high){
            temp[k++]  = nums[start2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[low+i] = temp[i];
        }
    }


}
