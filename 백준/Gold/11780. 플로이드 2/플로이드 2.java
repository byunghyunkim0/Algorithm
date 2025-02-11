import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 플로이드 2
public class Main {
    static final int INF = 123456789;
    static StringBuilder sb;
    static int[][] distance;
    static int[][] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], INF);
        }
        for (int i = 1; i <= n; i++) {
            distance[i][i] = 0;
        }

        int m = Integer.parseInt(br.readLine());

        pre = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            distance[start][end] = Math.min(distance[start][end], cost);
            pre[start][end] = start;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }

        sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == INF) {
                    distance[i][j] = 0;
                }
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == 0) {
                    sb.append("0\n");
                    continue;
                }
                getTrace(i, j);
            }
        }
        System.out.print(sb);
    }

    static void getTrace(int start, int end) {
        List<Integer> temp = new ArrayList<>();
        int cur = end;
        while (cur != start) {
            temp.add(cur);
            cur = pre[start][cur];
        }
        temp.add(start);
        sb.append(temp.size());
        for (int i = temp.size() - 1; i >= 0; i--) {
            sb.append(" ").append(temp.get(i));
        }
        sb.append("\n");
    }
}