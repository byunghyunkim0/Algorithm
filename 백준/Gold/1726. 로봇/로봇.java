import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 로봇
public class Main {
    static class Point {
        int x;
        int y;
        int dir;
        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        HashMap<Integer, Integer> dirMap = new HashMap<>();
        dirMap.put(1, 0);
        dirMap.put(2, 2);
        dirMap.put(3, 1);
        dirMap.put(4, 3);
        st = new StringTokenizer(br.readLine());
        Point start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, dirMap.get(Integer.parseInt(st.nextToken())));
        st = new StringTokenizer(br.readLine());
        Point end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, dirMap.get(Integer.parseInt(st.nextToken())));
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        boolean[][][] visited = new boolean[n][m][4];
        visited[start.x][start.y][start.dir] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.remove();
                if (cur.x == end.x && cur.y == end.y && cur.dir == end.dir) {
                    System.out.println(time);
                    return;
                }
                int nx = cur.x;
                int ny = cur.y;
                for (int d = 0; d < 3; d++) {
                    nx += dx[cur.dir];
                    ny += dy[cur.dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (visited[nx][ny][cur.dir]) {
                        continue;
                    }
                    if (map[nx][ny] == 1) {
                        break;
                    }
                    visited[nx][ny][cur.dir] = true;
                    queue.add(new Point(nx, ny, cur.dir));
                }
                int left = (cur.dir + 3) % 4;
                int right = (cur.dir + 1) % 4;
                if (!visited[cur.x][cur.y][left]) {
                    visited[cur.x][cur.y][left] = true;
                    queue.add(new Point(cur.x, cur.y, left));
                }
                if (!visited[cur.x][cur.y][right]) {
                    visited[cur.x][cur.y][right] = true;
                    queue.add(new Point(cur.x, cur.y, right));
                }
            }
            time++;
        }
    }
}