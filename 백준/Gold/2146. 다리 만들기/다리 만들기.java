import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기
public class Main {
    static class Point {
        int x;
        int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // when
        visited = new boolean[n][n];
        int result = 500;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                result = Math.min(bfs(i, j), result);
            }
        }

        // then
        System.out.println(result);
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> search = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        boolean[][] temp = new boolean[n][n];
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            boolean flag = false;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        flag = true;
                    } else {
                        queue.add(new Point(nx , ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            if (flag) {
                search.add(new Point(cur.x, cur.y));
                temp[cur.x][cur.y] = true;
            }
        }
        int count = 0;
        while (!search.isEmpty()) {
            int len = search.size();
            for (int i = 0; i < len; i++) {
                Point cur = search.remove();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !temp[nx][ny] && !visited[nx][ny]) {
                        if (map[nx][ny] == 1) {
                            return count;
                        } else {
                            search.add(new Point(nx, ny));
                            temp[nx][ny] = true;
                        }
                    }
                }
            }
            count++;
        }
        return count;
    }
}