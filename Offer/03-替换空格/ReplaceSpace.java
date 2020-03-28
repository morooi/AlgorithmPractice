public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace01(s));
        System.out.println(replaceSpace02(s));
        System.out.println(replaceSpace03(s));
    }

    /**
     * 从后往前
     */
    public static String replaceSpace01(String s) {
        // 将字符串转换为数组
        char[] oldC = s.toCharArray();
        // 遍历数组, 找到空格的个数
        int count = 0;
        for (char c : oldC) {
            if (c == 32) count++;
        }
        char[] newC = new char[oldC.length + count * 2];
        int p1 = oldC.length - 1;
        int p2 = newC.length - 1;
        while (p2 >= 0) {
            char c = oldC[p1--];
            if (c == ' ') {
                newC[p2--] = '0';
                newC[p2--] = '2';
                newC[p2--] = '%';
            } else {
                newC[p2--] = c;
            }
        }

        return new String(newC);
    }

    // StringBuilder
    public static String replaceSpace02(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    // 投机取巧
    public static String replaceSpace03(String s) {
        return s.replaceAll(" ", "%20");
    }
}
