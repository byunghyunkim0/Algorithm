import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 4
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // given
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // when
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] visited = new int[200001];
        int[] trace = new int[200001];
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            if (cur == k) {
                break;
            }
            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int nnx : next) {
                if (nnx >= 0 && nnx <= 200000 && visited[nnx] == 0) {
                    visited[nnx] = visited[cur] + 1;
                    trace[nnx] = cur;
                    queue.add(nnx);
                }
            }
        }
        int[] result = new int[visited[k]];
        result[0] = k;
        for (int i = 1; i < result.length; i++) {
            result[i] = trace[result[i - 1]];
        }

        // then
        StringBuilder sb = new StringBuilder();
        sb.append(visited[k] - 1).append("\n");
        for (int i = result.length - 1; i >= 0; i--) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}