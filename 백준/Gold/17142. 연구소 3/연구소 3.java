import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소 3
public class Main {
    static class Virus {
        int x;
        int y;
        boolean active;
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
            this.active = false;
        }
    }
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
    static int[][] map;
    static List<Virus> viruses;
    static int result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        viruses = new ArrayList<>();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j));
                }
            }
        }
        result = 123456;
        dfs(0, 0);
        if (result == 123456) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    static void dfs(int count, int idx) {
        if (idx == viruses.size()) return;
        if (count == m) {
            boolean[][] visited = new boolean[n][n];
            Queue<Point> virus = new LinkedList<>();
            for (Virus v : viruses) {
                if (!v.active) {
                    continue;
                }
                virus.add(new Point(v.x, v.y));
                visited[v.x][v.y] = true;
            }
            int time = 0;
            while (!virus.isEmpty()) {
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == 0 && !visited[i][j]) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
                int len = virus.size();
                for (int i = 0; i < len; i++) {
                    Point cur = virus.remove();
                    for (int d = 0; d < 4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] != 1) {
                            virus.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
                time++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0 && !visited[i][j]) {
                        return;
                    }
                }
            }
            result = Math.min(result, time);
            return;
        }
        for (int i = idx; i < viruses.size(); i++) {
            if (viruses.get(i).active) {
                continue;
            }
            viruses.get(i).active = true;
            dfs(count + 1, i);
            viruses.get(i).active = false;
        }
    }
}