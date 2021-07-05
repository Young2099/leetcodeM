package letcodeReview.dfs;

import kotlin.collections.ArraysKt;

import java.util.*;

public class AccountsMerge721 {
    public static void main(String[] args) {
        AccountsMerge721 accountsMerge721 = new AccountsMerge721();
        List<List<String>> accounts = new ArrayList<>();
        String[][] sy = new String[][]{{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}
                , {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        ArrayList<String> arrayList;
        for (int i = 0; i < sy.length; i++) {
            arrayList = new ArrayList<>();
            for (int j = 0; j < sy[i].length; j++) {
                arrayList.add(sy[i][j]);
            }
            accounts.add(arrayList);
        }
        List<List<String>> res = accountsMerge721.accountsMerge(accounts);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
        }

    }

    // 利用一个字符串的映射存储并查集
    Map<String, String> q;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        q = new HashMap<>();
        // 这个映射存储每个邮箱对应账户的名字
        Map<String, String> names = new HashMap<>();

        // 遍历所有账户构建并查集
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                if (!q.containsKey(a.get(i))) {
                    // 如果并查集中没有这个邮箱，则添加邮箱，其根元素就是本身
                    q.put(a.get(i), a.get(i));
                    // 添加该邮箱对应的账户名
                    names.put(a.get(i), a.get(0));
                }

                if (i > 1) {
                    // 并查集的合并操作，合并一个账户中的所有邮箱
                    q.put(find(a.get(i)), find(a.get(i - 1)));
                }
            }
        }

        // 暂时存储答案中的邮箱列表，每个键值对的键就是每个并查集集合的根元素
        Map<String, List<String>> temp = new HashMap<>();
        for (String email : q.keySet()) {
            // 获取当前邮箱对应并查集的根元素
            String root = find(email);
            // 将当前邮箱放入根元素对应的列表中
            if (!temp.containsKey(root)) temp.put(root, new ArrayList<>());
            temp.get(root).add(email);
        }

        // 将答案从映射中放到列表
        List<List<String>> res = new ArrayList();
        for (String root : temp.keySet()) {
            // 获取当前根元素对应的列表
            List<String> layer = temp.get(root);
            // 题目要求的排序
            Collections.sort(layer);
            // 添加姓名
            layer.add(0, names.get(root));
            // 将当前列表加入答案
            res.add(layer);
        }

        return res;
    }

    // 并查集查找模板函数，这里用字符串替换了之前的整型
    // find就是一个寻根归祖的方法，寻找当前元素最终将属于哪个根元素，这个根元素来表示一个联通集合
    // 如果x映射的值等于x，那就可以说明x是个根元素，例如一个集合中只有一个元素，那么它当然可以代表自己
    // 这样做可以让一个集合中的所有元素都能直接或者间接指向根元素，一个集合中只有一个元素的映射是本身
    private String find(String x) {
        // 判断x是不是就是一个根元素
        if (!q.get(x).equals(x)) {
            // x不是根，那就通过递归find函数来找到x映射的元素的根元素（寻根）
            // 找到根元素之后，通过put方法将x直接映射到根元素，这样就免去中间的多次递归（归祖）
            q.put(x, find(q.get(x)));
        }

        // 最终，x映射的元素就是x所在的集合的根元素，返回x的根元素
        return q.get(x);
    }


}
