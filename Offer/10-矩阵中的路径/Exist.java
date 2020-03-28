import org.junit.Test;

public class Exist {

    @Test
    public void test() {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        // 特别注意 i 对应 borad.lenght (矩阵的高), j 对应 board[0].lenght (矩阵的宽)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] chars, int i, int j, int index) {
        // 如果超出边界或者不等于目标字母, 返回 false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != chars[index]) {
            return false;
        }
        // 如果索引等于字母数组的长度, 说明找到了完整的路径, 返回 true
        if (chars.length - 1 == index) return true;

        // 访问过的设置为 "/"
        char temp = board[i][j];
        board[i][j] = '/';
        // 查找方向为 右, 下, 左, 上
        boolean result =
                dfs(board, chars, i + 1, j, index + 1) || dfs(board, chars, i, j + 1, index + 1) ||
                dfs(board, chars, i - 1, j, index + 1) || dfs(board, chars, i, j - 1, index + 1);
        // 回溯, 改回原值
        board[i][j] = temp;
        return result;
    }
}
