package letcodeReview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongstSubstring3 {
    public static void main(String[] args) {
       int a =  lengthOfLongestSubstring("abcabcbb");
       System.out.println(a);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1){
            return 1;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 0;
        int ans =0;
        for (int i = 0,j = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){
                j = Math.max(hashMap.get(s.charAt(i))+1,j);
            }
            ans = Math.max(ans,i-j+1);
            hashMap.put(s.charAt(i),i);

        }
        return ans;
    }


}
