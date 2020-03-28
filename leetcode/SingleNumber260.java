package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SingleNumber260 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int mask = xor & (-xor); // 取异或后的最后一位 1
        int[] res = new int[2];
        for (int num : nums) {
            if ((mask & num) == 0) {
                res[0] = res[0] ^ num;
            } else {
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }

    @Test
    public void test() {
        SingleNumber260 singleNumber260 = new SingleNumber260();
        System.out.println(Arrays.toString(singleNumber260.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
