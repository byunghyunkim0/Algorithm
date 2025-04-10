import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모노미노도미노 2
public class Main {
    static int score;
    static boolean[][] map = new boolean[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        score = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move(t, x, y);
            blueRemove();
            greenRemove();
            blueCheck();
            greenCheck();
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(score);
        System.out.println(count);
    }

    static void blueCheck() {
        int c = 0;
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[j][i]) {
                    c++;
                    break;
                }
            }
        }

        if (c == 0) {
            return;
        }

        for (int i = 9; i >= 4; i--) {
            for (int j = 0; j < 4; j++) {
                map[j][i] = map[j][i - c];
            }
        }
    }

    static void greenCheck() {
        int c = 0;
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j]) {
                    c++;
                    break;
                }
            }
        }

        if (c == 0) {
            return;
        }

        for (int i = 9; i >= 4; i--) {
            System.arraycopy(map[i - c], 0, map[i], 0, 4);
        }
    }

    static void blueRemove() {
        int idx = 4;
        while (idx < 10) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (!map[i][idx]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                idx++;
                continue;
            }
            for (int i = idx; i >= 4; i--) {
                for (int j = 0; j < 4; j++) {
                    map[j][i] = map[j][i - 1];
                }
            }
            score++;
        }
    }

    static void greenRemove() {
        int idx = 4;
        while (idx < 10) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (!map[idx][i]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                idx++;
                continue;
            }
            for (int i = idx; i >= 4; i--) {
                System.arraycopy(map[i - 1], 0, map[i], 0, 4);
            }
            score++;
        }
    }

    static void move(int type, int x, int y) {
        int bx = x;
        int by = y;
        int gx = x;
        int gy = y;
        if (type == 1) {
            while (by < 9 && !map[bx][by + 1]) {
                by++;
            }
            while (gx < 9 && !map[gx + 1][gy]) {
                gx++;
            }
        } else if (type == 2) {
            while (by < 8 && !map[bx][by + 2]) {
                by++;
            }
            while (gx < 9 && !map[gx + 1][gy] && !map[gx + 1][gy + 1]) {
                gx++;
            }
        } else {
            while (by < 9 && !map[bx][by + 1] && !map[bx + 1][by + 1]) {
                by++;
            }
            while (gx < 8 && !map[gx + 2][gy]) {
                gx++;
            }
        }
        map[bx][by] = true;
        map[gx][gy] = true;
        if (type == 2) {
            map[bx][by + 1] = true;
            map[gx][gy + 1] = true;
        } else if (type == 3) {
            map[bx + 1][by] = true;
            map[gx + 1][gy] = true;
        }
    }
}