package letcodeReview.fenzhi;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class SearchMatrix240 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean a = searchMatrix4(nums, 6);
        System.out.println(a);
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix4(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][matrix[0].length - 1] < target) {
                continue;
            }
            int col = binarySearch4(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }

    private static int binarySearch4(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) >> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;

        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }

    public static boolean searchMatrix3(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][matrix[0].length - 1] < target) {
                continue;
            }
            int col = binarySearch3(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;

    }

    private static int binarySearch3(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return 0;
            }
        }

        return -1;
    }

}
