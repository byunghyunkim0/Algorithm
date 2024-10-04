import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Σ
public class Main {
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int[] fraction = getFraction(s, n);

            if (fraction[1] == 1) {
                result += fraction[0] % MOD;
                result %= MOD;
                continue;
            }

            long temp = pow(fraction[1], MOD - 2);
            result += (fraction[0] * temp) % MOD;
            result %= MOD;
        }

        System.out.println(result);
    }

    static long pow (int num, int count) {
        if (count <= 1) {
            return num;
        }
        long temp = pow(num, count / 2);
        if ((count & 1) == 1) {
            return ((temp * temp) % MOD * num) % MOD;
        }
        return ((temp * temp) % MOD) % MOD;
    }

    static int[] getFraction (int a, int b) {
        int gcd = GCD(a, b);
        return new int[] {a / gcd, b / gcd};
    }

    static int GCD(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        return GCD(b, a % b);
    }
}