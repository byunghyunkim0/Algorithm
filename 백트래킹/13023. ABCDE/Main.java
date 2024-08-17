import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE
public class Main {
    static boolean flag;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        // when
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 1);
        }

        // then
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int n, int count) {
        if (count == 5 || flag) {
            flag = true;
            return;
        }
        for (int i = 0; i < graph[n].size(); i++) {
            int dest = graph[n].get(i);
            if (!visited[dest]) {
                visited[dest] = true;
                dfs(dest, count + 1);
                visited[dest] = false;
            }
        }
    }
}