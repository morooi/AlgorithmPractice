import javafx.scene.media.VideoTrack;

public class MovingCount {

    // 初始化一个计数器
    int count = 0;
    // 初始化一个矩阵, 保存是否访问过该点
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(m, n, 0, 0, k);

        return count;
    }

    public void dfs(int m, int n, int i, int j, int k) {
        // 以下情况返回: 超过边界, 数为和大于 k, 改点已访问过
        if (i >= m || i < 0 || j >= n || j < 0 || (i % 10 + i / 10 + j % 10 + j / 10) > k || visited[i][j]) {
            return;
        }
        count++;
        visited[i][j] = true;
        dfs(m, n, i, j + 1, k);
        dfs(m, n, i, j - 1, k);
        dfs(m, n, i + 1, j, k);
        dfs(m, n, i - 1, j, k);
    }
}
