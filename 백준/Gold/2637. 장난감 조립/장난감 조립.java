import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 장난감 조립
public class Main {
    static class Product {
        int idx;
        int count;
        public Product(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<List<Product>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degrees = new int[n + 1];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            degrees[y]++;
            graph.get(x).add(new Product(y, k));
        }
        boolean[] basic = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (graph.get(i).isEmpty()) {
                basic[i] = true;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] count = new int[n + 1];
        count[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (Product next : graph.get(cur)) {
                degrees[next.idx]--;
                count[next.idx] += count[cur] * next.count;
                if (degrees[next.idx] == 0) {
                    queue.add(next.idx);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (basic[i]) {
                sb.append(i).append(" ").append(count[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}