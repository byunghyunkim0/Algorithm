import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// LCA
public class Main {
    static List<List<Integer>> graph;
    static int[] depth;
    static int[][] parent;
    static int h;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;

        depth = new int[n + 1];
        parent = new int[n + 1][h];

        dfs(1, 0, 0);
        fillParent();

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        if (ah < bh) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = h - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = h - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    static void dfs(int node, int h, int p) {
        depth[node] = h;
        for (int next : graph.get(node)) {
            if (next != p) {
                dfs(next, h + 1, node);
                parent[next][0] = node;
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < n + 1; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }
}