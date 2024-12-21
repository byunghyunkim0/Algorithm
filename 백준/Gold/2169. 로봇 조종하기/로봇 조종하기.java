import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 조종하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < m; i++) {
            map[0][i] += map[0][i - 1];
        }

        int[][] side = new int[2][m];
        for (int i = 1; i < n; i++) {
            side[0][0] = map[i - 1][0] + map[i][0];
            for (int j = 1; j < m; j++) {
                side[0][j] = Math.max(side[0][j - 1], map[i - 1][j]) + map[i][j];
            }

            side[1][m - 1] = map[i - 1][m - 1] + map[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                side[1][j] = Math.max(side[1][j + 1], map[i - 1][j]) + map[i][j];
            }

            for (int j = 0; j < m; j++) {
                map[i][j] = Math.max(side[1][j], side[0][j]);
            }
        }

        System.out.println(map[n - 1][m - 1]);
    }
}