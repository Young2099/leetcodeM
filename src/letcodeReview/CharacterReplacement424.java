package letcodeReview;

import java.util.HashMap;

public class CharacterReplacement424 {
    public static void main(String[] args) {
        int a = characterReplacement("AABABBA", 1);
        System.out.println(a);
    }

    public static int characterReplacement(String s, int k) {
        int[] res = new int[26];
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxn = 0;//最大的重复字母
        char[] charArr = s.toCharArray();
        while (right < n) {
            int c = charArr[right] - 'A';
            res[c]++;
            maxn = Math.max(maxn, res[c]);
            if (right - left + 1 > maxn + k) {
                res[left]--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
