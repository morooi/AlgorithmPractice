import org.junit.Test;

public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1; // Java 中无符号右移操作符 ">>>"
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(9));
    }
}
