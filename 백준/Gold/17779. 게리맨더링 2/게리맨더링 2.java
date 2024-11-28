import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 게리맨더링 2
public class Main {
    static int n;
    static int[][] map;
    static int result;
    static int sum;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        result = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int i = 1; i < n - 1; i++) {
                    for (int j = 1; j < n - 1; j++) {
                        result = Math.min(result, count(x, y, i, j));
                    }
                }
            }
        }
        System.out.println(result);
    }
    static int count(int x, int y, int d1, int d2) {
        if (y - d1 < 0 || y + d2 >= n || x + d1 + d2 >= n) {
            return Integer.MAX_VALUE;
        }
        boolean[][] border = new boolean[n][n];
        int nx = x;
        int ny = y;
        int d = 0;
        for (int a = 0; a < 2; a++) {
            for (int i = 0; i < d1; i++) {
                nx += dx[d];
                ny += dy[d];
                border[nx][ny] = true;
            }
            d++;
            for (int i = 0; i < d2; i++) {
                nx += dx[d];
                ny += dy[d];
                border[nx][ny] = true;
            }
            d++;
        }

        int[] c = new int[5];
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) {
                    break;
                }
                c[0] += map[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) {
                    break;
                }
                c[1] += map[i][j];
            }
        }

        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y + d2 - d1; j++) {
                if (border[i][j]) {
                    break;
                }
                c[2] += map[i][j];
            }
        }

        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y + d2 - d1; j--) {
                if (border[i][j]) {
                    break;
                }
                c[3] += map[i][j];
            }
        }
        c[4] = sum;
        for (int i = 0; i < 4; i++) {
            c[4] -= c[i];
        }
        Arrays.sort(c);
        return c[4] - c[0];
    }
}