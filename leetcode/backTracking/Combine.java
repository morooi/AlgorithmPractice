package leetcode.backTracking;


import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/combinations/
 * https://mp.weixin.qq.com/s/qT6WgR6Qwn7ayZkI3AineA
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Combine {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> track = new ArrayList<>();
        backTrack(n, k, 1, track);
        return res;
    }

    private void backTrack(int n, int k, int start, ArrayList<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, k, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

}
