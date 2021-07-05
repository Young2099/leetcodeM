package letcodeReview.guihua;

public class LongestPalindrome5 {

    public static void main(String[] args) {
        String a = new LongestPalindrome5().longestPalindrome("abccba");
        System.out.println(a);
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (test.length() > max && isPal(test)) {
                    ans = test;
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public boolean isPal(String s) {
        int len = s.length();
        for (int i = 0; i < (len >> 1); i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(len)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}

