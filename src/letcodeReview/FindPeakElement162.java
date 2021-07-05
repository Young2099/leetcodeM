package letcodeReview;

public class FindPeakElement162 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        int a = findPeakElement(nums, 0, nums.length - 1);
        System.out.println(a);
    }

    public static int findPeakElement(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return findPeakElement(nums, l, mid);
        return findPeakElement(nums, mid + 1, r);

    }
    public static int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length -1;
        while (l < r){
            int mid = (l + r) / 2 ;
            if (nums[mid] > nums[mid+1]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
