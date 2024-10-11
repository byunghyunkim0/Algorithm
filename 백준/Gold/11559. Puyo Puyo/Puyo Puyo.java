import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Puyo Puyo
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static List<Point> boomList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int time = 0;
        while (true) {
            boomList = new ArrayList<>();
            visited = new boolean[12][6];
            for (int j = 0; j < 6; j++) {
                for (int i = 11; i >= 0; i--) {
                    if (map[i][j] == '.') {
                        break;
                    }
                    if (visited[i][j]) {
                        continue;
                    }
                    checkBoom(i, j);
                }
            }
            if (boomList.isEmpty()) {
                break;
            }
            time++;
            cleanMap();
            replaceMap();
        }

        System.out.println(time);
    }

    static void replaceMap() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    continue;
                }
                for (int k = i - 1; k >= 0; k--) {
                    if (map[k][j] != '.') {
                        char temp = map[i][j];
                        map[i][j] = map[k][j];
                        map[k][j] = temp;
                        break;
                    }
                }
            }
        }
    }

    static void cleanMap() {
        for (Point p : boomList) {
            map[p.x][p.y] = '.';
        }
    }

    static void checkBoom(int x, int y) {
        List<Point> list = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && map[nx][ny] == map[x][y]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    list.add(new Point(nx, ny));
                }
            }
        }
        if (list.size() >= 4) {
            boomList.addAll(list);
        }
    }
}