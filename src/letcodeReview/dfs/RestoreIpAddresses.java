package letcodeReview.dfs;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        new RestoreIpAddresses().restoreIpAddresses("010010");
    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList();
        Deque<String> temp = new LinkedList();
        dfs(s, 0, res, temp);
        return res;
    }

    private void dfs(String s, int index, ArrayList<String> res, Deque<String> temp) {
        if (index == s.length() && temp.size() == 4) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String a :
                    temp) {
                stringBuilder.append(a).append('.');
            }
            res.add(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
        }
        if (temp.size() > 4) {
            return;
        }
        for (int j = 1; j < 5; j++) {
            if (j + index - 1 >= s.length()) {
                return;
            }
            String str = s.substring(index, index + j);
            if (j != 1 && s.charAt(index) == '0') {
                return;
            }
            if (str.length() > 3 || Integer.parseInt(str) > 255) {
                return;
            }
            temp.add(str);
            dfs(s, index + j, res, temp);
            temp.removeLast();
        }
    }

}
