public class PrintNumbers {
    public int[] printNumbers(int n) {
        if (n <= 0) return new int[]{};
        int max = (int)Math.pow(10, n);
        int[] ints = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            ints[i] = i + 1;
        }

        return ints;
    }
}
