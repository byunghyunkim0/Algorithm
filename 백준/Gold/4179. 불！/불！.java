import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불!
public class Main {
    static int r;
    static int c;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> fire;
    static Queue<Point> jihoon;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Point {
        int x;
        int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Point cur = readInput();
        jihoon = new LinkedList<>();
        jihoon.add(cur);
        int time = 0;
        while (!jihoon.isEmpty()) {
            time++;
            int len = jihoon.size();
            doFire();
            for (int i = 0; i < len; i++) {
                cur = jihoon.remove();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                        System.out.println(time);
                        return;
                    }
                    if (!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        jihoon.add(new Point(nx, ny));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static void doFire() {
        int len = fire.size();
        for (int i = 0; i < len; i++) {
            Point curFire = fire.remove();
            for (int d = 0; d < 4; d++) {
                int nx = curFire.x + dx[d];
                int ny = curFire.y + dy[d];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
                    fire.add(new Point (nx, ny));
                    map[nx][ny] = 'F';
                }
            }
        }
    }

    static Point readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Point cur = new Point(0, 0);
        map = new char[r][c];
        visited = new boolean[r][c];
        fire = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'J') {
                    cur.x = i;
                    cur.y = j;
                    map[i][j] = '.';
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fire.add(new Point (i, j));
                }
            }
        }
        return cur;
    }
}