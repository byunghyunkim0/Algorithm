import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Maaaaaaaaaze
public class Main {
    static String[][][][] maze = new String[4][5][5][5];
    static int[] mazeRotateData = new int[5];
    static int[] mazeFloorData = new int[5];
    static boolean[] check = new boolean[5];
    static int count = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static class Point {
        int x;
        int y;
        int z;
        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int f = 0; f < 5; f++) {
            for (int i = 0; i < 5; i++) {
                maze[0][f][i] = br.readLine().split(" ");
            }
        }
        rotate();
        dfs(0);
        if (count == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

    static void dfs(int n) {
        if (n == 5) {
            check = new boolean[5];
            perm(0);
            return;
        }
        for (int i = 0; i < 4; i++) {
            mazeRotateData[n] = i;
            dfs(n + 1);
        }
    }

    static void perm(int count) {
        if (count == 5) {
            getCount();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            mazeFloorData[count] = i;
            perm(count + 1);
            check[i] = false;
        }
    }

    static void getCount() {
        String[][][] clone = new String[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                clone[i][j] = maze[mazeRotateData[i]][mazeFloorData[i]][j].clone();
            }
        }
        if (clone[0][0][0].equals("0") || clone[4][4][4].equals("0")) {
            return;
        }
        boolean[][][] visited = new boolean[5][5][5];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0,0));
        visited[0][0][0] = true;

        int c = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int l = 0; l < len; l++) {
                Point cur = queue.remove();
                if (cur.x == 4 && cur.y == 4 && cur.z == 4) {
                    count = Math.min(count, c);
                    return;
                }
                for (int d = 0; d < 6; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    int nz = cur.z + dz[d];
                    if (nx < 0 || nx > 4 || ny < 0 || ny > 4 || nz < 0 || nz > 4 || visited[nz][nx][ny]) {
                        continue;
                    }
                    if (clone[nz][nx][ny].equals("0")) {
                        continue;
                    }
                    queue.add(new Point(nx, ny, nz));
                    visited[nz][nx][ny] = true;
                }
            }
            c++;
        }
    }

    static void rotate() {
        for (int rotation = 1; rotation < 4; rotation++) {
            for (int f = 0; f < 5; f++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        maze[rotation][f][i][j] = maze[rotation - 1][f][4 - j][i];
                    }
                }
            }
        }
    }
}