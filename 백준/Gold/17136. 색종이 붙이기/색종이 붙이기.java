import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 붙이기
public class Main {
    static int[][] map;
    static int[] papers;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        papers = new int[6];
        result = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, int count) {
        if (x == 9 && y == 10) {
            result = Math.min(result, count);
            return;
        }

        if (count >= result) {
            return;
        }

        if (y > 9) {
            dfs(x + 1, 0, count);
            return;
        }

        if (map[x][y] == 1) {
            for (int size = 5; size > 0; size--) {
                if (papers[size] < 5 && check(x, y, size)) {
                    papers[size]++;
                    fill(x, y, size);
                    dfs(x, y + 1, count + 1);
                    papers[size]--;
                    delete(x, y, size);
                }
            }
        } else {
            dfs(x, y + 1, count);
        }
    }

    static boolean check(int x, int y, int len) {
        if (x + len > 10 || y + len > 10) {
            return false;
        }
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void fill(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                map[i][j] = 0;
            }
        }
    }

    static void delete(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                map[i][j] = 1;
            }
        }
    }
}