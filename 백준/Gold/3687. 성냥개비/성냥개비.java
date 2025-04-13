import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 성냥개비
public class Main {
    static long[] min = new long[101];
    static long[] count = {0, 0, 1, 7, 4, 2, 0, 8};
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        getMinNum();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(min[num]).append(" ");
            getMaxNum(num);
        }
        System.out.print(sb);
    }

    static void getMinNum() {
        Arrays.fill(min, Long.MAX_VALUE);
        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6;
        min[7] = 8;
        min[8] = 10;
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j < 8; j++) {
                long temp = min[i - j] * 10 + count[j];
                min[i] = Math.min(min[i], temp);
            }
        }
    }

    static void getMaxNum(int num) {
        if (num % 2 == 0) {
            sb.append("1".repeat(num / 2));
        } else {
            sb.append("7");
            sb.append("1".repeat(num / 2 - 1));
        }
        sb.append("\n");
    }
}