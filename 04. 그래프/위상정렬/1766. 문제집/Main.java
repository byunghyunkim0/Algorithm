import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 문제집
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // given
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> arr = new ArrayList<>();
            graph.add(arr);
        }
        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            degree[b]++;
        }

        // when
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            sb.append(cur).append(" ");
            for (int next : graph.get(cur)) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // then
        System.out.println(sb);
    }
}