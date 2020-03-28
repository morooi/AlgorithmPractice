import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            // 不能写成 "int i = 0; i < queue.size(); i++", 因为 queue 在变化
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    levelList.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            finalList.add(levelList);
        }
        return finalList;
    }

}
