import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소용돌이 예쁘게 출력하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] map = new int[r2 - r1 + 1][c2 - c1 + 1];
        int max = 0;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                map[i - r1][j - c1] = cal(i, j);
                max = Math.max(max, map[i - r1][j - c1]);
            }
        }

        String print = "%" + String.valueOf(max).length() + "d ";

        for (int[] arr : map) {
            for (int num : arr) {
                System.out.printf(print, num);
            }
            System.out.println();
        }
    }

    static int cal(int i, int j) {
        int depth = Math.max(Math.abs(i), Math.abs(j));

        int num = (2 * depth - 1) * (2 * depth - 1);

        if (i == depth) {
            return num + depth * 7 + j;
        } else if (j == -depth) {
            return num + depth * 5 + i;
        } else if (i == -depth) {
            return num + depth * 3 - j;
        }
        return num + depth - i;
    }
}