package letcodeReview;

public class IsPalindrome125 {
    public static void main(String[] args) {
      boolean a = isPalindrome("A man, a plan, a canal: Panama");
      System.out.println(a);
    }

    public static boolean isPalindrome(String s) {
        int left = 0,right = s.length() -1 ;
        while (left < right){
            while (left <right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right){
                if (Character.toLowerCase(s.charAt(left))  != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                ++left;
                --right;
            }

        }
        return true;
    }
}
