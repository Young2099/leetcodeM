package letcodeReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MaxVowels1456 {

    public static void main(String[] args) {
        int a = maxVowels1("tryhard", 4);
        System.out.println(a);
    }

    public static int maxVowels(String s, int k) {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
            }
        }
        int res = cnt;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                cnt--;
            }
            if (isVowel(s.charAt(i))) {
                cnt++;
                res = Math.max(res, cnt);
            }
        }
        return res;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int maxVowels1(String s, int k) {
        int n = s.length();
        int count = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        ans = count;
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            if (isVowel(s.charAt(i))) {
                count++;
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}