import org.junit.Test;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums[0] != 0) return 0;
        if (nums[nums.length - 1] != nums.length) return nums.length;

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] > m) j = m - 1;
            if (nums[m] == m) i = m + 1;
        }
        return i;
    }

    @Test
    public void test() {
        int[] a = new int[]{0, 1, 3};
        int[] b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] c = new int[]{0, 1};
        int[] d = new int[]{1};
        System.out.println(missingNumber(a));
        System.out.println(missingNumber(b));
        System.out.println(missingNumber(c));
        System.out.println(missingNumber(d));

    }
}
