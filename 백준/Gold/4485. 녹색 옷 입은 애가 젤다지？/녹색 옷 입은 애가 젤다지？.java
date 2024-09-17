import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class Main {
    static class Node {
        int cost;
        int x;
        int y;
        public Node (int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // given
        int number = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append("Problem ").append(number++).append(": ");
            // when
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
            queue.add(new Node(map[0][0], 0, 0));
            while (!queue.isEmpty()) {
                Node cur = queue.remove();
                if (cur.cost > cost[cur.x][cur.y]) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (cost[nx][ny] > cur.cost + map[nx][ny]) {
                            cost[nx][ny] = cur.cost + map[nx][ny];
                            queue.add(new Node(cost[nx][ny], nx, ny));
                        }
                    }
                }
            }
            sb.append(cost[n - 1][n - 1]).append("\n");
        }
        // then
        System.out.println(sb);
    }
}