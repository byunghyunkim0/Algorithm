import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 게임 개발
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n + 1];
        int[] times = new int[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                graph.get(num).add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                result[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.remove();

            for (int next : graph.get(cur)) {
                degree[next]--;
                result[next] = Math.max(result[next], result[cur] + times[next]);
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}