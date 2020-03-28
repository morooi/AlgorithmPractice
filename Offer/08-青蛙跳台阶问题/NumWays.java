public class NumWays {

    public int numWays(int n) {
        if (n < 0) {
            return -1;
        } else if (n ==0) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
