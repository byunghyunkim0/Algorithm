import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

// 회의준비
public class Main {
    static int[] parent;
    static int[][] distance;
    static final int INF = 123456789;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        distance = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = 1;
            distance[b][a] = 1;
            union(find(a), find(b));
        }
        for (int i = 0; i <= n; i++) {
            parent[i] = find(i);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(parent[i])) {
                map.put(parent[i], new ArrayList<>());
            }
            map.get(parent[i]).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int p : map.keySet()) {
            res.add(getCount(map.get(p)));
        }
        res.sort(Comparator.comparingInt(o -> o));

        StringBuilder sb = new StringBuilder();
        sb.append(res.size()).append("\n");
        for (int r : res) {
            sb.append(r).append("\n");
        }
        System.out.print(sb);
    }

    static int getCount(List<Integer> set) {
        int idx = -1;
        int count = Integer.MAX_VALUE;
        for (int i : set) {
            int temp = 0;
            for (int j : set) {
                temp = Math.max(temp, distance[i][j]);
            }
            if (count > temp) {
                idx = i;
                count = temp;
            }
        }
        return idx;
    }

    static int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}