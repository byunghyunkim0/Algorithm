import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 가스관
public class Main {
    static int r;
    static int c;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static HashMap<Character, Integer> dir = new HashMap<>(){{
        put('|', 10);
        put('-', 5);
        put('+', 15);
        put('1', 3);
        put('2', 9);
        put('3', 12);
        put('4', 6);
    }};

    static class Point {
        int x;
        int y;
        public Point() {

        }
    }
    static Point end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        Point start = new Point();
        end = new Point();
        for (int i = 0; i < r; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (temp[j] == 'M') {
                    start.x = i;
                    start.y = j;
                } else if (temp[j] == 'Z') {
                    end.x = i;
                    end.y = j;
                }
                if (dir.containsKey(temp[j])) {
                    map[i][j] = dir.get(temp[j]);
                }
            }
        }
        int d = -1;
        for (int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            if (map[nx][ny] != 0) {
                d = i;
            }
        }
        start.x += dx[d];
        start.y += dy[d];

        while (true) {
            map[start.x][start.y] -= (1 << (d + 2) % 4);
            if ((map[start.x][start.y] & (1 << d)) == 0) {
                for (int i = 0; i < 4; i++) {
                    if ((map[start.x][start.y] & (1 << i)) != 0) {
                        d = i;
                        break;
                    }
                }
            }
            map[start.x][start.y] -= (1 << d);
            start.x += dx[d];
            start.y += dy[d];
            if (map[start.x][start.y] == 0) {
                for (char c : dir.keySet()) {
                    if ((dir.get(c) & (1 << (d + 2) % 4)) == 0) {
                        continue;
                    }
                    map[start.x][start.y] = dir.get(c);
                    if (check(move(start.x, start.y, d))) {
                        start.x++;
                        start.y++;
                        System.out.println(start.x + " " + start.y + " " + c);
                        return;
                    }
                }
            }
        }
    }

    static int[][] move(int x, int y, int d) {
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            res[i] = map[i].clone();
        }

        while (true) {
            res[x][y] -= (1 << (d + 2) % 4);
            if ((res[x][y] & (1 << d)) == 0) {
                for (int i = 0; i < 4; i++) {
                    if ((res[x][y] & (1 << i)) != 0) {
                        d = i;
                        break;
                    }
                }
            }
            res[x][y] -= (1 << d);
            x += dx[d];
            y += dy[d];
            if (x < 0 || x >= r || y < 0 || y >= c || (res[x][y] & (1 << (d + 2) % 4)) == 0) {
                break;
            }
        }
        return res;
    }

    static boolean check(int[][] m) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}