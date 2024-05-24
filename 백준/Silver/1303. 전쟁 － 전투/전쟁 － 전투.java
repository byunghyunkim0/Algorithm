import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static char[][] board;
    static int countW;
    static int countB;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new char[n][m];
        countW = 0;
        countB = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            board[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (board[i][j] == 'W') {
                        countW += bfs(i, j);
                    } else {
                        countB += bfs(i, j);
                    }
                }
            }
        }
        System.out.printf("%s %s", countW, countB);
    }

    static int bfs(int x, int y) {
        int result = 1;
        char w = board[x][y];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] == w){
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    result++;
                }
            }
        }
        return result * result;
    }
}