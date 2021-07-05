package sort;

import letcodeReview.TreeNode;
import letcodeReview.node.Node;

import java.util.*;

public class TestC {
    public Node1 getNode(Node1 node1){
        Set<Node1> set = new HashSet<>();
        while (node1 != null){
            if (!set.contains(node1)){
                set.add(node1);
            }else {
                return node1;
            }
            node1 = node1.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node1 node6 = new Node1(6, null);
        Node1 node5 = new Node1(5, node6);
        Node1 node4 = new Node1(4, node5);
        Node1 node3 = new Node1(3, node4);
        Node1 node2 = new Node1(2, node3);
        Node1 node1 = new Node1(1, node2);
        node6.next = node3;
//        while (node1 != null) {
//            System.out.println(node1.val);
//            node1 = node1.next;
//
//        }
        Node1  node11 = new TestC().getNode(node1);
        System.out.println("args = " +node11.val);
//        Node1 nodeNew = new TestC().resetNode(node1);
//        while (nodeNew != null) {
//            System.out.println(nodeNew.val);
//            nodeNew = nodeNew.next;
//
//        }
//        int a = new TestC().revetNum(1234);
//        System.out.println(a);
//        List<List<Integer>> a = new TestC().a(new int[]{1, 2, 3});
//        System.out.println(a);
//        HashMap<Character,Integer> hashMap = new TestC().getCountMap("abccasa");
//        System.out.println(hashMap);

    }

    public Node1 resetNode(Node1 node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node1 node1 = resetNode(node.next);
        node.next.next = node;
        node.next = null;
        return node1;
    }

    /**
     * 1234
     *
     * @param num
     * @return
     */
    public int revetNum(int num) {
        int a = 0;
        int d = num;
        if (num >= Integer.MAX_VALUE) {
            return -1;
        }
        while (d != 0) {
            int p = d % 10;

            a = a * 10 + p;
            d = d / 10;
        }
        return a;
    }

    public int treeHi(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = treeHi(treeNode.left);
        int right = treeHi(treeNode.right);
        return Math.max(left, right) + 1;
    }


    public void revest(String a) {

    }

    /**
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * @return
     */
    public List<List<Integer>> a(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        getSubset(list, stack, nums, 0);
        return list;
    }

    private void getSubset(List<List<Integer>> list, Stack<Integer> stack, int[] nums, int index) {
        list.add(new ArrayList<>(stack));
        for (int i = index; i < nums.length; i++) {
            stack.add(nums[i]);
            getSubset(list, stack, nums, i + 1);
            stack.pop();
        }
    }

    private HashMap<Character, Integer> getCountMap(String a) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch :
                a.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.getOrDefault(ch, 1) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        return hashMap;
    }

}
