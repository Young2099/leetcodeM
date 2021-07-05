package letcodeReview.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度搜索优先
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        int a = maxDepth.maxDepth2(treeNode);
        System.out.println(a);
    }

    /**
     * 广度优先
     *
     * @param treeNode
     * @return
     */
    private int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int count = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(treeNode);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.pop();
                size--;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            count++;

        }
        return count;
    }

    public int maxDepth2(TreeNode root) {

        return root == null ? 0 : Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
