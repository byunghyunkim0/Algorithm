import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 마법사 상어와 토네이도
public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static class Move {
        int a;
        int b;
        double percent;
        public Move(int a, int b, double percent) {
            this.a = a;
            this.b = b;
            this.percent = percent;
        }
    }
    static class Point {
        int x;
        int y;
        int dir;
        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int result;
    static List<Move> direction;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        direction = new ArrayList<>();
        direction.add(new Move(0, 1, 0.01));
        direction.add(new Move(0, -1, 0.01));
        direction.add(new Move(1, 1, 0.07));
        direction.add(new Move(1, -1, 0.07));
        direction.add(new Move(1, 2, 0.02));
        direction.add(new Move(1, -2, 0.02));
        direction.add(new Move(2, 1, 0.1));
        direction.add(new Move(2, -1, 0.1));
        direction.add(new Move(3, 0, 0.05));

        boolean[][] visited = new boolean[n][n];
        result = 0;
        Point start = new Point(n / 2, n / 2, 0);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            visited[cur.x][cur.y] = true;
            if (cur.x == 0 && cur.y == 0) {
                break;
            }
            move(cur.x, cur.y, cur.dir);
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];
            int nDir = (cur.dir + 1) % 4;
            if (visited[nx + dx[nDir]][ny + dy[nDir]]) {
                queue.add(new Point(nx, ny, cur.dir));
            } else {
                queue.add(new Point(nx, ny, nDir));
            }
        }
        System.out.println(result);
    }

    static void move(int x, int y, int dir) {
        int sandX = x + dx[dir];
        int sandY = y + dy[dir];
        int sand = map[sandX][sandY];
        for (Move move : direction) {
            int nx;
            int ny;
            if (dir % 2 == 0) {
                nx = x + move.b;
                ny = y + dy[dir] * move.a;
            } else {
                nx = x + dx[dir] * move.a;
                ny = y + move.b;
            }
            int dif = (int)(map[sandX][sandY] * move.percent);
            sand -= dif;
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                result += dif;
                continue;
            }
            map[nx][ny] += dif;
        }
        int tempX = x + dx[dir] * 2;
        int tempY = y + dy[dir] * 2;
        if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            map[tempX][tempY] += sand;
        } else {
            result += sand;
        }
        map[sandX][sandY] = 0;
    }
}