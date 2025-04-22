import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 물통
public class Main {
    static class Work {
        int a;
        int b;
        public Work(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[a + 1][b + 1];
        visited[0][0] = true;

        Queue<Work> works = new LinkedList<>();
        works.add(new Work(0, 0));

        int time = 0;
        while (!works.isEmpty()) {
            int len = works.size();
            for (int i = 0; i < len; i++) {
                Work cur = works.remove();
                if (cur.a == c && cur.b == d) {
                    System.out.println(time);
                    return;
                }

                if (!visited[a][cur.b]) {
                    visited[a][cur.b] = true;
                    works.add(new Work(a, cur.b));
                }
                if (!visited[cur.a][b]) {
                    visited[cur.a][b] = true;
                    works.add(new Work(cur.a, b));
                }

                if (!visited[0][cur.b]) {
                    visited[0][cur.b] = true;
                    works.add(new Work(0, cur.b));
                }
                if (!visited[cur.a][0]) {
                    visited[cur.a][0] = true;
                    works.add(new Work(cur.a, 0));
                }

                int sum = cur.a + cur.b;
                if (!visited[Math.min(sum, a)][Math.max(sum - a, 0)]) {
                    visited[Math.min(sum, a)][Math.max(sum - a, 0)] = true;
                    works.add(new Work(Math.min(sum, a), Math.max(sum - a, 0)));
                }

                if (!visited[Math.max(sum - b, 0)][Math.min(sum, b)]) {
                    visited[Math.max(sum - b, 0)][Math.min(sum, b)] = true;
                    works.add(new Work(Math.max(sum - b, 0), Math.min(sum, b)));
                }
            }
            time++;
        }
        System.out.println(-1);
    }
}