import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 운동
public class Main {
    static final int INF = 123456789;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] cost = new int[v][v];

        for (int i = 0; i < v; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            cost[a][b] = c;
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        int result = INF;

        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                result = Math.min(result, cost[i][j] + cost[j][i]);
            }
        }

        if (result == INF) {
            result = -1;
        }
        System.out.println(result);
    }
}