import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 할로윈의 양아치
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] child = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            child[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int[][] group = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
            group[parent[i]][0]++;
            group[parent[i]][1] += child[i];
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (group[i][0] != 0) {
                list.add(new int[] {group[i][0], group[i][1]});
            }
        }

        int[][] dp = new int[list.size() + 1][k];
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            int[] cur = list.get(i - 1);
            int count = cur[0];
            int candy = cur[1];
            for (int j = 1; j < k; j++) {
                if (j >= count) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - count] + candy);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }

    static int find (int child) {
        if (parent[child] != child) {
            return parent[child] = find(parent[child]);
        }
        return child;
    }

    static void union (int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pb] = pa;
    }
}