package leetcode.backTracking;


import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/permutations/
 * https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
 * 全排列
 * 给定一个 *没有重复* 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permute {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        backTrack(nums, track);
        return res;
    }

    private void backTrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        }
        for (int num : nums) {
            if (track.contains(num)) continue;
            track.add(num);
            backTrack(nums, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] test = {1, 2, 3};
        List<List<Integer>> res = permute.permute(test);
        System.out.println(res);
    }
}
