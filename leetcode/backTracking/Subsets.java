package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/subsets/
 * https://mp.weixin.qq.com/s/qT6WgR6Qwn7ayZkI3AineA
 *
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        backTrack(nums, 0, track);
        return res;
    }

    private void backTrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] a = {1, 2, 3};
        System.out.println(subsets.subsets(a));
    }
}
