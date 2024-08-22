import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        n = Integer.parseInt(st.nextToken());

        // when
        sb = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            if (isPrime(i)) {
                dfs(i, 1);
            }
        }

        // then
        System.out.println(sb);
    }

    public static void dfs(int number, int count) {
        if (isPrime(number)) {
            if (count == n) {
                sb.append(number).append("\n");
            } else {
                for (int i = 0; i < 10; i++) {
                    dfs(number * 10 + i, count + 1);
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}