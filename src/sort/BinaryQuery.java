package sort;

public class BinaryQuery {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        boolean a = new BinaryQuery().binaryQuery(arr, 2);
        System.out.println(a);
    }

    public boolean binaryQuery(int[] arr, int temp) {
        int low = 0;
        int hi = arr.length - 1;
        while (low <= hi) {
            int mid = (low + hi) >> 1;
            if (arr[mid] > temp) {
                hi = mid - 1;
            } else if (arr[mid] < temp) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
