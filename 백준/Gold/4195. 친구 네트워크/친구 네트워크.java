import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 친구 네트워크
public class Main {
    static HashMap<String, Integer> map;
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int f = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            rank = new int[f * 2];
            parent = new int[f * 2];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

            int idx = 0;
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                map.putIfAbsent(a, idx++);
                map.putIfAbsent(b, idx++);

                System.out.println(union(map.get(a), map.get(b)));
            }
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    static int union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
            rank[pa] += rank[pb];
        }
        return rank[pa];
    }
}