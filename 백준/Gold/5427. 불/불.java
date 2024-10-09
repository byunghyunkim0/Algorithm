import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 불
public class Main {
    static class Point {
        int x;
        int y;
        public Point () {

        }
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int w;
    static int h;
    static char[][] map;
    static Queue<Point> queue;
    static boolean[][] visited;
    static Queue<Point> fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < test; tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            Point player = new Point();

            fire = new LinkedList<>();
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        player.x = i;
                        player.y = j;
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') {
                        fire.add(new Point(i, j));
                    }
                }
            }

            visited = new boolean[h][w];

            queue = new LinkedList<>();
            queue.add(player);
            visited[player.x][player.y] = true;
            int time = 0;
            boolean flag = true;

            while (!queue.isEmpty()) {
                time++;
                doFire();
                if (move()) {
                    sb.append(time).append("\n");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append("IMPOSSIBLE\n");
            }
        }

        System.out.println(sb);
    }

    static boolean move() {
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    return true;
                }
                if (!visited[nx][ny] && map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new Point (nx, ny));
                }
            }
        }
        return false;
    }

    static void doFire() {
        int len = fire.size();
        for (int i = 0; i < len; i++) {
            Point cur = fire.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                    map[nx][ny] = '*';
                    fire.add(new Point(nx, ny));
                }
            }
        }
    }
}