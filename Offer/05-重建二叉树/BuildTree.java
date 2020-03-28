import java.util.HashMap;

public class BuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    HashMap<Integer, Integer> map = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        po = preorder;
        for (int i : inorder) {
            map.put(inorder[i], i);
        }
        return recurrent(0, 0, preorder.length - 1);
    }

    public TreeNode recurrent(int pre_root, int left_index, int right_index) {
        if (left_index > right_index) return null;
        TreeNode node = new TreeNode(po[pre_root]);
        int i = map.get(po[pre_root]);
        node.left = recurrent(pre_root + 1, left_index, i - 1);
        node.right = recurrent(pre_root + (i - left_index) + 1, i + 1, right_index); // 根节点索引 + 左子树长度 + 1,
        return node;
    }
}
