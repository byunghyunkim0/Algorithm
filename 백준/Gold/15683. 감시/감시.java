import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 감시
public class Main {
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static int n;
    static int m;
    static int result;
    static int[][] map;
    static int[] cctvInfo = new int[] {0, 1, 2, 2, 3};
    static List<Point> cctv;
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cctv = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 5) {
                    cctv.add(new Point(i, j));
                }
            }
        }

        // when
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 5) {
                    for (int d = 0; d < 4; d++) {
                        detect(i, j, d, true);
                    }
                }
            }
        }
        result = 100;
        dfs(0);

        // then
        System.out.println(result);
    }

    static void dfs(int idx) {
        if (idx == cctv.size()) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        temp++;
                    }
                }
            }
            result = Math.min(result, temp);
            return;
        }
        Point cur = cctv.get(idx);
        if (map[cur.x][cur.y] == 2) {
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i < 2; i++) {
                    detect(cur.x, cur.y, i * 2 + d, true);
                }
                dfs(idx + 1);
                for (int i = 0; i < 2; i++) {
                    detect(cur.x, cur.y, i * 2 + d, false);
                }
            }
        } else {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < cctvInfo[map[cur.x][cur.y]]; i++) {
                    detect(cur.x, cur.y, (i + d) % 4, true);
                }
                dfs(idx + 1);
                for (int i = 0; i < cctvInfo[map[cur.x][cur.y]]; i++) {
                    detect(cur.x, cur.y, (i + d) % 4, false);
                }
            }
        }
    }

    static void detect(int x, int y, int d, boolean isDetect) {
        int nx = x;
        int ny = y;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                break;
            }
            if (map[nx][ny] == 6) {
                break;
            }
            if (map[nx][ny] > 0) {
                continue;
            }
            if (isDetect) {
                map[nx][ny]--;
            } else {
                map[nx][ny]++;
            }
        }
    }
}