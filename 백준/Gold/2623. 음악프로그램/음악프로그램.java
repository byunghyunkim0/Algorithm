import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 음악프로그램
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degrees = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                degrees[next]++;
                graph.get(cur).add(next);
                cur = next;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                degrees[next]--;
                if (degrees[next] == 0) {
                    queue.add(next);
                }
            }
            sb.append(cur).append("\n");
        }
        for (int i = 1; i <= n; i++) {
            if (degrees[i] != 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);

    }
}