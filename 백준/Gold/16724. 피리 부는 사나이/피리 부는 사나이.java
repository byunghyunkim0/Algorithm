import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 피리 부는 사나이
public class Main {
    static class Direction {
        int right;
        int down;
        public Direction(int r, int d) {
            this.right = r;
            this.down = d;
        }
    }
    static HashMap<Character, Direction> d;
    static char[][] map;
    static int[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        d = new HashMap<>();
        d.put('D', new Direction(0, 1));
        d.put('R', new Direction(1, 0));
        d.put('L', new Direction(-1, 0));
        d.put('U', new Direction(0, -1));

        map = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0) {
                    continue;
                }
                visited[i][j] = 1;
                dfs(i, j);
                visited[i][j] = -1;
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        Direction curD = d.get(map[x][y]);
        int nx = x + curD.down;
        int ny = y + curD.right;

        if (visited[nx][ny] == 0) {
            visited[nx][ny] = 1;
            dfs(nx, ny);
            visited[nx][ny] = -1;
        } else if (visited[nx][ny] == -1) {
            count--;
        }
    }
}