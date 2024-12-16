import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트 택시
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, f;
    static int[][] map;
    static Point[] destination;
    static Point cur;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        cur = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        destination = new Point[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i + 2;
            destination[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        for (int i = 0; i < m; i++) {
            select(); // 손님 태우러 가기, 거리 리턴
            if (f == -1) {
                System.out.println(f);
                return;
            }
            move(); // 목적지까지 이동, 거리 리턴
            if (f == -1) {
                System.out.println(f);
                return;
            }
        }
        System.out.println(f);
    }

    static void select() {
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur.x][cur.y] = true;
        if (map[cur.x][cur.y] > 1) {
            return;
        }

        List<Point> dest = new ArrayList<>();
        int dist = 0;
        while (!queue.isEmpty() && dest.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.remove();
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (map[nx][ny] == 1 || visited[nx][ny]) {
                        continue;
                    }
                    if (map[nx][ny] > 1) {
                        dest.add(new Point(nx, ny));
                    }
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
            dist++;
        }
        dest.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        f = Math.max(-1, f - dist);
        if (dest.isEmpty()) {
            f = -1;
            return;
        }
        cur = dest.get(0);
    }

    static void move() {
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur.x][cur.y] = true;
        int idx = map[cur.x][cur.y] - 2;
        map[cur.x][cur.y] = 0;
        int dist = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.remove();
                if (destination[idx].x == p.x && destination[idx].y == p.y) {
                    cur = p;
                    if (f < dist) {
                        f = -1;
                        return;
                    }
                    f += dist;
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (map[nx][ny] == 1 || visited[nx][ny]) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
            dist++;
        }
        f = -1;
    }
}