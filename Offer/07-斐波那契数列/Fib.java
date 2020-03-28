public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int i1 = 0;
        int i2 = 1;
        for (int i = 2; i <= n; i++) {
            int sum = i1 + i2;
            i1 = i2;
            i2 = sum;
        }
        return i2 % 1000000007;
    }
}
