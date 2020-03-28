package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode-cn.com/problems/find-k-closest-elements/
 */
public class FindClosestElements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 5, 5, 6, 6, 7, 7, 8, 9};
        FindClosestElements658 mm = new FindClosestElements658();
        System.out.println(mm.findClosestElements(arr, 7, 7));
    }

}
