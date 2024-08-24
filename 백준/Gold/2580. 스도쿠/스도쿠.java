import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠
public class Main {

    static int[][] map;
    static int c;
    static boolean finish = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        c = 0;
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    c++;
                }
            }
        }

        // when
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (!finish && check(i, j, num)) {
                            map[i][j] = num;
                            dfs(1);
                        }
                    }
                }
            }
        }
    }

    public static void dfs(int count) {
        if (count == c) {
            finish = true;
            // then
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (!finish && check(i, j, num)) {
                            map[i][j] = num;
                            dfs(count + 1);
                            map[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
    }

    public static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (i != x && map[i][y] == num) {
                return false;
            }
            if (i != y && map[x][i] == num) {
                return false;
            }
        }
        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (i != x && j != y && map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}