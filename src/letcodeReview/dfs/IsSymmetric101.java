package letcodeReview.dfs;

import letcodeReview.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric101 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 4, 4, 3};
        IsSymmetric101 isSymmetric101 = new IsSymmetric101();
        TreeNode node = new TreeNode();
        node.val = 1;
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(12);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        boolean b = isSymmetric101.isSymmetric(node);
        System.out.println(b);
    }

    public boolean isSymmetric(TreeNode root) {
        return check1(root);
    }

    /**
     * dfs 深度优先
     *
     * @param left
     * @param right
     * @return
     */
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && (check(left.left, right.right) && (check(left.right, right.left)));
    }

    /**
     * bfs 广度优先
     *
     * @param node
     * @return
     */
    private boolean check1(TreeNode node) {
        if (node == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);
        while (queue.size() > 0) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //这里有可能节点为null。还得继续向下循环
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }


}
