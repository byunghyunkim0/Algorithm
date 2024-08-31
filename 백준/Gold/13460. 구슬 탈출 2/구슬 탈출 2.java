import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬 탈출 2
public class Main {
    static class Point {
        int x;
        int y;
        public Point () {

        }
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Balls {
        Point red;
        Point blue;
        public Balls() {

        }
        public Balls(Point red, Point blue) {
            this.red = red;
            this.blue = blue;
        }
    }
    static char[][] map;
    static Queue<Balls> queue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static Point target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        Balls init = new Balls();
        target = new Point();

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'B') {
                    init.blue = new Point(i, j);
                    map[i][j] = '.';
                } else if (map[i][j] == 'R') {
                    init.red = new Point(i, j);
                    map[i][j] = '.';
                } else if (map[i][j] == 'O') {
                    target.x = i;
                    target.y = j;
                }
            }
        }

        // when
        boolean[][][][] visited = new boolean[n][m][n][m];
        queue = new LinkedList<>();
        queue.add(init);
        visited[init.red.x][init.red.y][init.blue.x][init.blue.y] = true;

        int count = 0;
        boolean flag = true;
        f : while (!queue.isEmpty() && count <= 10) {
            count++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Balls cur = queue.remove();
                for (int d = 0; d < 4; d++) {
                    Point nRed = new Point(cur.red.x, cur.red.y);
                    Point nBlue = new Point(cur.blue.x, cur.blue.y);
                    move(nRed, d);
                    move(nBlue, d);
                    if (nBlue.x == target.x && nBlue.y == target.y) {
                        continue;
                    }
                    if (nRed.x == target.x && nRed.y == target.y) {
                        flag = false;
                        break f;
                    }
                    if (nRed.x == nBlue.x && nRed.y == nBlue.y) {
                        if (d == 0) {
                            if (cur.red.y >= cur.blue.y) {
                                nBlue.y -= dy[d];
                            } else {
                                nRed.y -= dy[d];
                            }
                        } else if (d == 1) {
                            if (cur.red.x >= cur.blue.x) {
                                nBlue.x -= dx[d];
                            } else {
                                nRed.x -= dx[d];
                            }
                        } else if (d == 2) {
                            if (cur.red.y < cur.blue.y) {
                                nBlue.y -= dy[d];
                            } else {
                                nRed.y -= dy[d];
                            }
                        } else {
                            if (cur.red.x < cur.blue.x) {
                                nBlue.x -= dx[d];
                            } else {
                                nRed.x -= dx[d];
                            }
                        }
                    }
                    if (!visited[nRed.x][nRed.y][nBlue.x][nBlue.y]) {
                        visited[nRed.x][nRed.y][nBlue.x][nBlue.y] = true;
                        queue.add(new Balls(nRed, nBlue));
                    }

                }
            }
        }

        // then
        if (count >= 11 || flag) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    static void move(Point point, int d) {
        while (true) {
            point.x += dx[d];
            point.y += dy[d];
            if (map[point.x][point.y] == '#') {
                point.x -= dx[d];
                point.y -= dy[d];
                break;
            }
            if (map[point.x][point.y] == 'O') {
                break;
            }
        }
    }
}