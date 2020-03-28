public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int top = 0, right = col - 1, buttom = row - 1, left = 0;
        int count = 0;

        while (true) {
            // 右移到右边界
            for (int i = left; i <= right; i++) {
                res[count++] = matrix[top][i];
            }
            if (++top > buttom) break;  // 读取完上边一排, 更新上边界(下移 1), 不满足边界条件即结束

            // 下移到下边界
            for (int i = top; i <= buttom; i++) {
                res[count++] = matrix[i][right];
            }
            if (--right < left) break;  // 读取完右边一列, 更新右边界(左移 1), 不满足边界条件即结束

            // 左移到左边界
            for (int i = right; i >= left; i--) {
                res[count++] = matrix[buttom][i];
            }
            if (--buttom < top ) break;  // 读取完下边一列, 更新下边界(上移 1), 不满足边界条件即结束

            // 右移到右边界
            for (int i = buttom; i >= top; i--) {
                res[count++] = matrix[i][left];
            }
            if (++left > right) break;  // 读取完左边一列, 更新左边界(右移 1), 不满足边界条件即结束
        }
        return res;
    }

}
