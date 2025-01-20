import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 하노이 탑
public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        BigInteger res = new BigInteger("2");
        sb.append(res.pow(n).subtract(new BigInteger("1"))).append("\n");
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
        }
        System.out.print(sb);
    }

    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(n - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(n - 1, mid, start, end);
    }
}