import org.junit.Test;

public class MyPow {
    public double myPow(double x, int n) {
        // 此处注意, double 类型不可以直接用 == 来判断
        if (x < 1e-7 && x > -1e-7) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(2.00000, 0));
        System.out.println(myPow(0.00000, 0));
    }

}
