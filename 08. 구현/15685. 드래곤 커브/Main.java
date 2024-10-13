import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 드래곤 커브
public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int n = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // when
            curve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // then
        System.out.println(getCount());
    }

    static void curve(int y, int x, int d, int repeat) {
        int[] direction = new int[(int)Math.pow(2, repeat)];
        direction[0] = d;
        for (int i = 1; i < direction.length; i *= 2) {
            for (int j = 0; j < i; j++) {
                direction[i + j] = (direction[i - j - 1] + 1) % 4;
            }
        }
        int nx = x;
        int ny = y;
        map[nx][ny] = true;
        for (int dir : direction) {
            nx += dx[dir];
            ny += dy[dir];
            map[nx][ny] = true;
        }
    }

    static int getCount() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    result++;
                }
            }
        }
        return result;
    }
}