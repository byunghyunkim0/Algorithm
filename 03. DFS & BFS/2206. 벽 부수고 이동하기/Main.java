import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
public class Main {
    static class Point {
        int x;
        int y;
        boolean breaker;
        public Point(int x, int y, boolean breaker) {
            this.x = x;
            this.y = y;
            this.breaker = breaker;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        // when
        int[][][] costs = new int[n][m][2];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, false));
        costs[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == '0') {
                        // 방문할 곳이 이동가능하다면
                        if (cur.breaker && costs[nx][ny][1] == 0) {
                            queue.add(new Point(nx, ny, true));
                            costs[nx][ny][1] = costs[cur.x][cur.y][1] + 1;
                        } else if (!cur.breaker && costs[nx][ny][0] == 0){
                            queue.add(new Point(nx, ny, false));
                            costs[nx][ny][0] = costs[cur.x][cur.y][0] + 1;
                        }
                    } else if (map[nx][ny] == '1' && !cur.breaker && costs[nx][ny][1] == 0) {
                        // 방문할 곳이 벽이라면
                        queue.add(new Point(nx, ny, true));
                        costs[nx][ny][1] = costs[cur.x][cur.y][0] + 1;
                    }
                }
            }
        }

        // then
        int costRes = costs[n - 1][m - 1][0];
        int breakRes = costs[n - 1][m - 1][1];
        if (costRes == 0 && breakRes == 0) {
            System.out.println(-1);
        } else if (costRes == 0 || breakRes == 0) {
            System.out.println(Math.max(costRes, breakRes));
        } else {
            System.out.println(Math.min(costRes, breakRes));
        }
    }
}