import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 캐슬 디펜스
public class Main {
    static int n;
    static int m;
    static int d;
    static boolean[] archers;
    static int[][] monster;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};
    static int result;
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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        monster = new int[n][m];
        archers = new boolean[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                monster[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        for (int i = 0; i < m; i++) {
            archers[i] = true;
            dfs(1, i);
            archers[i] = false;
        }
        System.out.println(result);
    }

    static void dfs(int count, int idx) {
        if (idx == m) {
            return;
        }
        if (count == 3) {
            int[][] copyMonsters = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(monster[i], 0, copyMonsters[i], 0, m);
            }
            result = Math.max(result, getScore(copyMonsters));
            return;
        }
        for (int i = idx + 1; i < m; i++) {
            if (archers[i]) {
                continue;
            }
            archers[i] = true;
            dfs(count + 1, i);
            archers[i] = false;
        }
    }

    static int getScore(int[][] monsters) {
        int count = 0;
        Queue<Point> hunting = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (!archers[j]) {
                    continue;
                }
                Point monster = getMonster(i, j, monsters);
                if (monster != null) {
                    hunting.add(monster);
                }
            }
            while (!hunting.isEmpty()) {
                Point cur = hunting.remove();
                if (monsters[cur.x][cur.y] == 1) {
                    count++;
                    monsters[cur.x][cur.y] = 0;
                }
            }
        }
        return count;
    }

    static Point getMonster(int x, int y, int[][] monsters) {
        boolean[][] visited = new boolean[x + 1][m];
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        for (int c = 0; c < d; c++) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.remove();
                if (monsters[cur.x][cur.y] == 1) {
                    return new Point(cur.x, cur.y);
                }
                for (int d = 0; d < 3; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return null;
    }
}