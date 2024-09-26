import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경사로
public class Main {
    static int n;
    static int l;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // given
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // when
        int count = 2 * n;
        boolean[][] slopeA = new boolean[n][n];
        boolean[][] slopeB = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
                    count--;
                    break;
                }
                if (map[i][j] > map[i][j + 1]) {
                    boolean flag = false;
                    for (int a = 1; a <= l; a++) {
                        if (j + a >= n) {
                            flag = true;
                            break;
                        }
                        if (map[i][j + a] != map[i][j + 1] || slopeA[i][j + a]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        count--;
                        break;
                    }
                    for (int a = 1; a <= l; a++) {
                        slopeA[i][j + a] = true;
                    }
                } else if (map[i][j] < map[i][j + 1]) {
                    boolean flag = false;
                    for (int a = 0; a < l; a++) {
                        if (j - a < 0) {
                            flag = true;
                            break;
                        }
                        if (map[i][j - a] != map[i][j] || slopeA[i][j - a]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        count--;
                        break;
                    }
                    for (int a = 0; a < l; a++) {
                        slopeA[i][j - a] = true;
                    }
                }
            }
            for (int j = 0; j < n - 1; j++) {
                if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
                    count--;
                    break;
                }
                if (map[j][i] > map[j + 1][i]) {
                    boolean flag = false;
                    for (int a = 1; a <= l; a++) {
                        if (j + a >= n) {
                            flag = true;
                            break;
                        }
                        if (map[j + a][i] != map[j + 1][i] || slopeB[j + a][i]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        count--;
                        break;
                    }
                    for (int a = 1; a <= l; a++) {
                        slopeB[j + a][i] = true;
                    }
                } else if (map[j][i] < map[j + 1][i]) {
                    boolean flag = false;
                    for (int a = 0; a < l; a++) {
                        if (j - a < 0) {
                            flag = true;
                            break;
                        }
                        if (map[j - a][i] != map[j][i] || slopeB[j - a][i]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        count--;
                        break;
                    }
                    for (int a = 0; a < l; a++) {
                        slopeB[j - a][i] = true;
                    }
                }
            }
        }
        // then
        System.out.println(count);
    }
}