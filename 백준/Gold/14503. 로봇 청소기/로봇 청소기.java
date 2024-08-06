import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result;
    static int x;
    static int y;
    static int d;
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        d = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        result = 0;
        while (true) {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                result++;
            }
            if (check()) {
                int nd = (2 + d) % 4;
                if (map[x + dx[nd]][y + dy[nd]] != 1) {
                    x += dx[nd];
                    y += dy[nd];
                } else {
                    break;
                }
            } else {
                d = (3 + d) % 4;
                if (map[x + dx[d]][y + dy[d]] == 0) {
                    x += dx[d];
                    y += dy[d];
                }
            }
        }
        System.out.println(result);
    }

    public static boolean check() {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[nx][ny] == 0) {
                return false;
            }
        }
        return true;
    }
}