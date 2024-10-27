import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사다리 조작
public class Main {
    static int n;
    static int m;
    static int h;
    static Point[][] map;
    static boolean finish;
    static int maxCount;
    static class Point {
        boolean left;
        boolean right;
        public Point () {
            this.left = false;
            this.right = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new Point[h][n];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new Point();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1].right = true;
            map[a - 1][b].left = true;
        }

        finish = false;
        for (int i = 0; i <= 3; i++) {
            maxCount = i;
            dfs(0, 0);
            if (finish) {
                break;
            }
        }
        if (!finish) {
            System.out.println(-1);
        }
    }

    static void dfs(int count, int s) {
        if (finish) {
            return;
        }
        if (count == maxCount) {
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (!move(i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                finish = true;
                System.out.println(count);
                return;
            }
            return;
        }
        for (int i = s; i < h; i++) {
            for (int j = 1; j < n; j++) {
                if (!map[i][j].left && !map[i][j - 1].right) {
                    map[i][j].left = true;
                    map[i][j - 1].right = true;
                    dfs(count + 1, i);
                    map[i][j].left = false;
                    map[i][j - 1].right = false;
                }
            }
        }
    }

    static boolean move(int start) {
        int y = start;
        for (int i = 0; i < h; i++) {
            if (map[i][y].left) {
                y--;
            } else if (map[i][y].right) {
                y++;
            }
        }
        return y == start;
    }
}