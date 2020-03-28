import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // LinkedList 双端队列
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if ((level & 1) == 0) {
                        levelList.addLast(node.val);
                    } else {
                        levelList.addFirst(node.val);
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            finalList.add(levelList);
            level++;
        }
        return finalList;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                root = queue.poll();
                if (root != null) {
                    list.add(root.val);
                    if (root.left != null) queue.add(root.left);
                    if (root.right != null) queue.add(root.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
