import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 칵테일
public class Main {
    static class Node {
        int node;
        int p;
        int q;
        public Node(int node, int p, int q) {
            this.node = node;
            this.p = p;
            this.q = q;
        }
    }
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();
    static long[] stuff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        stuff = new long[n];
        stuff[0] = 1;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, p, q));
            graph.get(b).add(new Node(a, q, p));
            stuff[0] *= (p * q / getGcd(p, q));
        }

        visited = new boolean[n];
        dfs(0);
        long gcd = stuff[0];
        for (int i = 1; i < n; i++) {
            gcd = getGcd(gcd, stuff[i]);
        }
        for (int i = 0; i < n; i++) {
            stuff[i] /= gcd;
        }

        for (long res : stuff) {
            System.out.print(res + " ");
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (Node next : graph.get(node)) {
            if (visited[next.node]) {
                continue;
            }
            stuff[next.node] = stuff[node] * next.q / next.p;
            dfs(next.node);
        }
    }

    static long getGcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}