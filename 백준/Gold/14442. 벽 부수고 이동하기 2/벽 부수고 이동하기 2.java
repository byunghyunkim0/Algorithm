import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 2
public class Main {
    static class Point {
        int x;
        int y;
        int count;
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        int distance = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.remove();
                if (cur.x == n - 1 && cur.y == m - 1) {
                    System.out.println(distance);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (map[nx][ny] == '1') {
                        if (cur.count < k && !visited[nx][ny][cur.count + 1]) {
                            visited[nx][ny][cur.count + 1] = true;
                            queue.add(new Point(nx, ny, cur.count + 1));
                        }
                        continue;
                    }
                    if (!visited[nx][ny][cur.count]) {
                        visited[nx][ny][cur.count] = true;
                        queue.add(new Point(nx, ny, cur.count));
                    }
                }
            }
            distance++;
        }
        System.out.println(-1);
    }
}