import java.util.ArrayList;

public class IsSymmetric {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        // 都为 null 说明 left 和 right 同时越过叶子节点, 对称
        if (left == null && right == null) return true;
        // 若 left == null, right == null 有一个为 true, 说明 left 和 right 只有一个越过叶子节点, 不对称
        if (left == null || right == null) return false;
        // 值不相等, 不对称
        if (left.val != right.val) return false;

        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
