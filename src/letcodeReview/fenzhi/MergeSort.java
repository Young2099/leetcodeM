package letcodeReview.fenzhi;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 7, 3, 1, 9, 4};
        mergeSort(arr, 0, arr.length - 1);
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left +1];
        int start1 = left;
        int start2= mid+1;
        int index = 0;
        while (start1 <= mid && start2 <= right){
            temp[index++]  = arr[start1] <= arr[start2] ? arr[start1++]:arr[start2++];
        }
        while (start1 <= mid){
            temp[index++] = arr[start1++];
        }
        while (start2 <= right){
            temp[index++]  = arr[start2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left+i] = temp[i];
        }
    }

}
