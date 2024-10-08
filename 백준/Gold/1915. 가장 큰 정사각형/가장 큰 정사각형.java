import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 정사각형
public class Main {
    static int n;
    static int m;
    static char[][] map;
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        count = new int[n + 1][m + 1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i - 1][j - 1] == '1') {
                    count[i][j] = getSize(i - 1, j - 1, count[i - 1][j - 1] + 1);
                    maxLen = Math.max(maxLen, count[i][j]);
                }
            }
        }

        System.out.println(maxLen * maxLen);
    }

    static int getSize(int x, int y, int len) {
        int r = 0;
        int c = 0;
        for (int i = x; i > x - len; i--) {
            if (map[i][y] == '1') {
                r++;
            } else {
                break;
            }
        }
        for (int j = y; j > y - len; j--) {
            if (map[x][j] == '1') {
                c++;
            } else {
                break;
            }
        }
        return Math.min(r, c);
    }
}