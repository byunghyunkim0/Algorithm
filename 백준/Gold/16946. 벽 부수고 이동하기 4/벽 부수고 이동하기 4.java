import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 4
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int m;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] visited;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && map[i][j] == '0') {
                    idx++;
                    bfs(i, j, idx);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1') {
                    int sum = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        if (visited[nx][ny] != 0) {
                            set.add(visited[nx][ny]);
                        }
                    }
                    for (int index : set) {
                        sum += hashMap.get(index);
                    }
                    sb.append(sum % 10);
                    continue;
                }
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y, int index) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = index;
        int c = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == '0' && visited[nx][ny] == 0) {
                    visited[nx][ny] = index;
                    queue.add(new Point(nx, ny));
                }
            }
            c++;
        }
        hashMap.put(index, c);
    }
}