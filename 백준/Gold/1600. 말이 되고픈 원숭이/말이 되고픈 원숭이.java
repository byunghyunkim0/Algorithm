import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
public class Main {
    static class Point {
        int x;
        int y;
        int horseMove;

        public Point (int x, int y, int horseMove) {
            this.x = x;
            this.y = y;
            this.horseMove = horseMove;
        }
    }
    static int w;
    static int h;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] ddx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] ddy = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Point start = new Point(0, 0, k);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        boolean[][][] visited = new boolean[h][w][k + 1];
        visited[0][0][k] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.remove();
                if (cur.x == h - 1 && cur.y == w - 1) {
                    System.out.println(time);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 0 && !visited[nx][ny][cur.horseMove]) {
                        queue.add(new Point(nx, ny, cur.horseMove));
                        visited[nx][ny][cur.horseMove] = true;
                    }
                }
                if (cur.horseMove == 0) {
                    continue;
                }
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + ddx[d];
                    int ny = cur.y + ddy[d];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 0 && !visited[nx][ny][cur.horseMove - 1]) {
                        queue.add(new Point(nx, ny, cur.horseMove - 1));
                        visited[nx][ny][cur.horseMove - 1] = true;
                    }
                }
            }
            time++;
        }
        System.out.println(-1);
    }
}