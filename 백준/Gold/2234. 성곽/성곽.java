import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 성곽
public class Main {
    static int[][] map;
    static int[][] visited;
    static int[] roomCount;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int m;
    static int maxMakeRoom;

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[n][m];
        roomCount = new int[2501];
        int roomidx = 0;
        int maxRoom = 0;
        maxMakeRoom = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0) {
                    continue;
                }
                roomidx++;
                maxRoom = Math.max(bfs(i, j, roomidx), maxRoom);
            }
        }
        System.out.println(roomidx);
        System.out.println(maxRoom);
        System.out.println(maxMakeRoom);
    }

    static int bfs(int x, int y, int roomIdx) {
        int count = 1;
        int otherRoom = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = roomIdx;
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if ((map[cur.x][cur.y] & (1 << d)) > 0) {
                    otherRoom = Math.max(otherRoom, roomCount[visited[nx][ny]]);
                    continue;
                }
                if (visited[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = roomIdx;
                    count++;
                }
            }
        }
        maxMakeRoom = Math.max(count + otherRoom, maxMakeRoom);
        return roomCount[roomIdx] = count;
    }
}