import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 인구 이동
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int l;
    static int r;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> works;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // when
        works = new LinkedList<>();
        flag = true;
        int days = -1;
        while (flag) {
            flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        change(bfs(i, j));
                    }
                }
            }
            days++;
        }

        // then
        System.out.println(days);
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        works.add(new Point(x, y));
        visited[x][y] = true;
        int sum = map[x][y];
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                    if (diff >= l && diff <= r) {
                        Point work = new Point(nx, ny);
                        visited[nx][ny] = true;
                        queue.add(work);
                        works.add(work);
                        sum += map[nx][ny];
                    }
                }
            }
        }
        return sum;
    }

    static void change(int sum) {
        if (works.size() > 1) {
            flag = true;
        }
        int c = sum / works.size();
        while (!works.isEmpty()) {
            Point cur = works.remove();
            map[cur.x][cur.y] = c;
        }
    }
}