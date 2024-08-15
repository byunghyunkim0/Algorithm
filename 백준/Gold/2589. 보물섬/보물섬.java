import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int l;
    static int w;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        w = sc.nextInt();
        map = new char[l][w];
        for (int i = 0; i < l; i++) {
            map[i] = sc.next().toCharArray();
        }
        int res = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'L') {
                    res = Math.max(res, bfs(i, j));
                }
            }
        }
        System.out.println(res);
    }

    static int bfs(int x, int y) {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[l][w];
        queue.add(new Point(x, y));
        visited[x][y] = 1;
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < l && ny >= 0 && ny < w && visited[nx][ny] == 0 && map[nx][ny] == 'L') {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    result = Math.max(result, visited[nx][ny]);
                }
            }
        }
        return result - 1;
    }
}