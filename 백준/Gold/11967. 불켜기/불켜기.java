import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 불켜기
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
    static int n;
    static boolean[][] visited;
    static boolean[][] onLight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<List<Point>>> rooms = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            rooms.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                rooms.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rooms.get(x).get(y).add(new Point(a, b));
        }

        visited = new boolean[n + 1][n + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        visited[1][1] = true;
        onLight = new boolean[n + 1][n + 1];
        onLight[1][1] = true;
        int count = 1;
        List<Point> checkPoint = new ArrayList<>();
        checkPoint.add(new Point(1, 1));

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (Point next : rooms.get(cur.x).get(cur.y)) {
                if (onLight[next.x][next.y]) {
                    continue;
                }
                onLight[next.x][next.y] = true;
                count++;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx <= 0 || nx > n || ny <= 0 || ny > n || !onLight[nx][ny] || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                checkPoint.add(new Point(nx, ny));
            }
            if (queue.isEmpty()) {
                for (Point next : checkPoint) {
                    if (check(next.x, next.y)) {
                        queue.add(new Point(next.x, next.y));
                    }
                }
            }
        }
        System.out.println(count);
    }

    static boolean check(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
                continue;
            }
            if (!visited[nx][ny] && onLight[nx][ny]) {
                return true;
            }
        }
        return false;
    }
}