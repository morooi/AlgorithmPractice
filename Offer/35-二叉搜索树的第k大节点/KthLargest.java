public class KthLargest {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        if (root == null || k < 1) return -1;
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}


