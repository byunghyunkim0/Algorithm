import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내가 살게, 아냐 내가 살게
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] sum = new int[n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sum[i] += map[i][j];
                if (sum[i] >= k) {
                    System.out.printf("%d %d", i + 1, j + 1);
                    return;
                }
            }
        }
    }
}