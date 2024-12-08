import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빵집
public class Main {
    static int r;
    static int c;
    static char[][] map;
    static int result;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        result = 0;
        for (int i = 0; i < r; i++) {
            if (map[i][0] == 'x') {
                continue;
            }
            if (dfs(i, 0)) {
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean dfs(int x, int y) {
        map[x][y] = 'x';
        if (y == c - 1) {
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            if (map[nx][ny] == '.') {
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }
        return false;
    }
}