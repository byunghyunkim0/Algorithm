import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이분 그래프
public class Main {
    static int[] points;
    static List<Integer>[] graph;
    static StringBuilder sb;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int k = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int test = 0; test < k; test++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            // when
            points = new int[v + 1];
            flag = true;
            for (int i = 1; i < v; i++) {
                if (points[i] == 0 && flag) {
                    points[i] = 1;
                    bfs(i);
                }
            }
            if (flag) {
                sb.append("YES").append("\n");
            }

        }
        // then
        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.remove();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if (points[next] == 0) {
                        queue.add(next);
                        points[next] = points[cur] * (-1);
                    } else if (points[next] * points[cur] == 1) {
                        flag = false;
                        sb.append("NO").append("\n");
                        return;
                    }
                }
            }
        }
    }
}