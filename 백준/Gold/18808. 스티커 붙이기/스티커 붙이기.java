import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 스티커 붙이기
public class Main {
    static class Sticker {
        int r;
        int c;
        int[][] sticker;
        public Sticker(int r, int c, int[][] sticker) {
            this.r = r;
            this.c = c;
            this.sticker = sticker;
        }
    }
    static boolean[][] map;
    static int n;
    static int m;
    static int k;
    static List<Sticker> stickers;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        stickers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sn = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[sn][sm];
            for (int x = 0; x < sn; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < sm; y++) {
                    sticker[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(sn, sm, sticker));
        }

        map = new boolean[n][m];
        result = 0;
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int count, int res) {
        if (count == k) {
            result = Math.max(res, result);
            return;
        }
        Sticker cur = stickers.get(count);
        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cur.r + i > n || cur.c + j > m) {
                        continue;
                    }
                    int temp = attach(i, j, cur);
                    if (temp == -1) {
                        continue;
                    }
                    dfs(count + 1, res + temp);
                }
            }
            if (r != 3) {
                rotate(cur);
            }
        }
        dfs(count + 1, res);
    }

    static int attach(int x, int y, Sticker sticker) {
        int c = 0;
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.sticker[i][j] == 1) {
                    if (map[i + x][j + y]) {
                        return -1;
                    }
                    c++;
                }
            }
        }
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.sticker[i][j] == 1) {
                    map[i + x][j + y] = true;
                }
            }
        }
        return c;
    }

    static void rotate(Sticker sticker) {
        int[][] tempSticker = new int[sticker.c][sticker.r];
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                tempSticker[j][sticker.r - 1 - i] = sticker.sticker[i][j];
            }
        }
        int temp = sticker.c;
        sticker.c = sticker.r;
        sticker.r = temp;
        sticker.sticker = tempSticker;
    }
}