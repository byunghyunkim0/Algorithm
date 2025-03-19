import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 궁금한 민호
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] check = new boolean[n][n];

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (distance[i][j] == distance[i][k] + distance[k][j]) {
                        check[i][j] = true;
                        check[j][i] = true;
                    }
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!check[i][j]) {
                    res += distance[i][j];
                }
            }
        }
        System.out.println(res);
    }
}