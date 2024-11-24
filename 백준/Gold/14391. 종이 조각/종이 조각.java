import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 종이 조각
public class Main {
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int result = 0;
        int cases = 1 << (n * m);
        for (int c = 0; c < cases; c++) {
            result = Math.max(getSum(c), result);
        }
        System.out.println(result);
    }

    private static int getSum(int c) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = m - 1; j >= 0; j--) {
                if ((c & 1 << (i * m + j)) > 0) {
                    sum += map[i][j] * temp;
                    temp *= 10;
                    continue;
                }
                temp = 1;
            }
        }
        for (int j = 0; j < m; j++) {
            int temp = 1;
            for (int i = n - 1; i >= 0; i--) {
                if ((c & 1 << (i * m + j)) == 0) {
                    sum += map[i][j] * temp;
                    temp *= 10;
                    continue;
                }
                temp = 1;
            }
        }
        return sum;
    }
}