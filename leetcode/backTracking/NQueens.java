package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/n-queens
 * https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
 */
public class NQueens {

    private final List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(board, 0);
        return res;
    }

    private void backTrack(char[][] board, int row) {
        if (row >= board.length) {
            ArrayList<String> boardRes = new ArrayList<>();
            for (char[] chars : board) {
                boardRes.add(new String(chars));
            }
            res.add(boardRes);
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;  // 如果不能放下，就跳过
            }
            board[row][col] = 'Q';
            backTrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
