import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 통나무 옮기기
public class Main {
    static int n;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Point {
        int x;
        int y;
        int dir;
        public Point() {
        }

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }


        Point start = new Point();
        Point end = new Point();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'B') {
                    start = getPoint(i, j);
                } else if (map[i][j] == 'E') {
                    end = getPoint(i, j);
                }
            }
        }

        visited = new boolean[n][n][2];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
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

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny][cur.dir] || !checkM(nx, ny, cur.dir)) {
                        continue;
                    }
                    queue.add(new Point(nx, ny, cur.dir));
                    visited[nx][ny][cur.dir] = true;
                }
                if (!checkT(cur.x, cur.y)) {
                    continue;
                }
                int nd;
                if (cur.dir == 1) {
                    nd = 0;
                } else {
                    nd = 1;
                }
                if (!visited[cur.x][cur.y][nd]) {
                    queue.add(new Point(cur.x, cur.y, nd));
                    visited[cur.x][cur.y][nd] = true;
                }
            }
            time++;
        }
        System.out.println(0);
    }

    static boolean checkM(int x, int y, int dir) {
        if (dir == 1) {
            for (int i = y - 1; i <= y + 1; i++) {
                if (i < 0 || i >= n || map[x][i] == '1') {
                    return false;
                }
            }
        } else {
            for (int i = x - 1; i <= x + 1; i++) {
                if (i < 0 || i >= n || map[i][y] == '1') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkT(int x, int y) {
        if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
            return false;
        }

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (map[i][j] == '1') {
                    return false;
                }
            }
        }
        return true;
    }

    static Point getPoint(int x, int y) {
        if (x + 1 < n && map[x][y] == map[x + 1][y]) {
            map[x][y] = '0';
            map[x + 1][y] = '0';
            map[x + 2][y] = '0';
            return new Point(x + 1, y, 0);
        }
        map[x][y] = '0';
        map[x][y + 1] = '0';
        map[x][y + 2] = '0';
        return new Point(x, y + 1,1);
    }
}