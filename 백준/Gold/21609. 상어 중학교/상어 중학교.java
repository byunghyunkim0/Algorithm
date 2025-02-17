import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 상어 중학교
public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int res;
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        while (remove()) {
            gravity();
            rotate();
            gravity();
        }
        System.out.println(res);
    }

    static boolean remove() {
        List<Point> removeB = new ArrayList<>();
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= 0 || check[i][j]) {
                    continue;
                }

                List<Point> getRemoveBlock = bfs(i, j, map[i][j], check);
                if (getRemoveBlock.size() <= 1) {
                    continue;
                }
                if (change(removeB, getRemoveBlock)) {
                    removeB = getRemoveBlock;
                }
            }
        }

        if (removeB.size() <= 1) {
            return false;
        }

        res += removeB.size() * removeB.size();
        for (Point block : removeB) {
            map[block.x][block.y] = -2;
        }
        return true;
    }

    static boolean change(List<Point> remove, List<Point> temp) {
        if (remove.size() < temp.size()) {
            return true;
        }
        if (remove.size() == temp.size()) {
            int count = 0;
            for (Point p : remove) {
                if (map[p.x][p.y] == 0) {
                    count++;
                }
            }
            for (Point p : temp) {
                if (map[p.x][p.y] == 0) {
                    count--;
                }
            }
            return count <= 0;
        }
        return false;
    }

    static List<Point> bfs(int x, int y, int block, boolean[][] check) {
        boolean[][] visited = new boolean[n][n];

        List<Point> temp = new ArrayList<>();

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        temp.add(new Point(x, y));
        visited[x][y] = true;
        check[x][y] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 0 || map[nx][ny] == block) {
                    queue.add(new Point(nx, ny));
                    temp.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    check[nx][ny] = true;
                }
            }
        }
        return temp;
    }

    static void rotate() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[j][n - i - 1];
            }
        }
        map = temp;
    }

    static void gravity() {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != -2) {
                    continue;
                }
                int nx = i - 1;
                while (nx >= 0) {
                    if (map[nx][j] == -1) {
                        break;
                    }

                    if (map[nx][j] != -2) {
                        int temp = map[nx][j];
                        map[nx][j] = -2;
                        map[i][j] = temp;
                        break;
                    }
                    nx--;
                }
            }
        }
    }
}