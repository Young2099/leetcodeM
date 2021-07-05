package letcodeReview.dfs;

import letcodeReview.TreeNode;

public class IsSameTree100 {

    public static void main(String[] args) {
        IsSameTree100 sameTree100 = new IsSameTree100();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
//        tree1.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(1);
//        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        boolean s = sameTree100.isSameTree(tree1, tree2);
        System.out.println(s);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if(p.val != q.val) {
            return false;
        }else {
            return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

}


