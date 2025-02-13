import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 게임
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int max;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dp = new int[n][m];
        max = 0;
        dp[0][0] = 1;
        visited = new boolean[n][m];
        dfs(new Point(0, 0), 1);

        if (flag) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);
    }

    static void dfs(Point cur, int count) {
        max = Math.max(max, count);
        dp[cur.x][cur.y] = count;

        for (int d = 0; d < 4; d++) {
            int nx = cur.x + dx[d] * (map[cur.x][cur.y] - '0');
            int ny = cur.y + dy[d] * (map[cur.x][cur.y] - '0');

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'H') {
                continue;
            }

            if (visited[nx][ny]) {
                flag = true;
                return;
            }

            if (dp[nx][ny] > count) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(new Point(nx, ny), count + 1);
            visited[nx][ny] = false;
        }
    }
}