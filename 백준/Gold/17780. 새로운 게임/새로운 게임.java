import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 새로운 게임
public class Main {
    static int n;
    static int k;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static class Block {
        int type;
        int bottom = -1;
        List<Integer> blocks = new ArrayList<>();
        public Block(int type) {
            this.type = type;
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
    static Block[][] board;
    static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new Block[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = new Block(Integer.parseInt(st.nextToken()));
            }
        }

        points = new Point[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y, dir);
            board[x][y].blocks.add(i);
            board[x][y].bottom = i;
        }

        int count = 1;
        while (count <= 1000) {
            for (int i = 0; i < k; i++) {
                if (board[points[i].x][points[i].y].bottom != i) {
                    continue;
                }

                check(i);
                move(i);

                if (board[points[i].x][points[i].y].blocks.size() >= 4) {
                    System.out.println(count);
                    return;
                }
            }
            count++;
        }
        System.out.println(-1);
    }

    static void move(int idx) {
        Point cur = points[idx];
        int nx = cur.x + dx[cur.dir];
        int ny = cur.y + dy[cur.dir];

        if (blueCheck(nx, ny)) {
            return;
        }

        if (board[nx][ny].type == 1) {
            redCheck(cur.x, cur.y);
        }

        if (board[nx][ny].blocks.isEmpty()) {
            board[nx][ny].bottom = board[cur.x][cur.y].bottom;
        }
        board[nx][ny].blocks.addAll(board[cur.x][cur.y].blocks);
        board[cur.x][cur.y].blocks = new ArrayList<>();
        board[cur.x][cur.y].bottom = -1;
        for (int point : board[nx][ny].blocks) {
            points[point].x = nx;
            points[point].y = ny;
        }
    }

    static void check(int idx) {
        Point cur = points[idx];
        int nx = cur.x + dx[cur.dir];
        int ny = cur.y + dy[cur.dir];

        if (blueCheck(nx, ny)) {
            if (points[idx].dir == 1) {
                points[idx].dir = 2;
            } else if (points[idx].dir == 2) {
                points[idx].dir = 1;
            } else if (points[idx].dir == 3) {
                points[idx].dir = 4;
            } else {
                points[idx].dir = 3;
            }
        }
    }

    static void redCheck(int x, int y) {
        Collections.reverse(board[x][y].blocks);
        board[x][y].bottom = board[x][y].blocks.get(0);
    }

    static boolean blueCheck(int x, int y) {
        return x <= 0 || x > n || y <= 0 || y > n || board[x][y].type == 2;
    }
}