import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 알고스팟
public class Main {
    static class Node {
        int x;
        int y;
        int cost;
        public Node (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static int n;
    static int m;
    static int[][] map;
    static int[][] cost;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // given
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // when
        cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], 10000);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(0, 0, 0));
        cost[0][0] = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cost[cur.x][cur.y] < cur.cost) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (cost[nx][ny] > cost[cur.x][cur.y] + map[nx][ny]) {
                        cost[nx][ny] = cost[cur.x][cur.y] + map[nx][ny];
                        queue.add(new Node(nx, ny, cost[nx][ny]));
                    }
                }
            }
        }

        // then
        System.out.println(cost[n - 1][m - 1]);
    }
}