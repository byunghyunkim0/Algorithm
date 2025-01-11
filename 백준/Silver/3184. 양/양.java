import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 양
public class Main {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int sheep;
    static int wolf;
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        sheep = 0;
        wolf = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#' || visited[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int tempS = 0;
        int tempW = 0;
        if (map[x][y] == 'v') {
            tempW++;
        } else if (map[x][y] == 'o') {
            tempS++;
        }
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == '#') {
                    continue;
                }
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                if (map[nx][ny] == 'v') {
                    tempW++;
                } else if (map[nx][ny] == 'o') {
                    tempS++;
                }
            }
        }
        if (tempS > tempW) {
            sheep += tempS;
            return;
        }
        wolf += tempW;
    }
}