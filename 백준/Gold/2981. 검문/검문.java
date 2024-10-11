import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 검문
public class Main {
    static int n;
    static int[] num;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        int divisor;
        if (n == 2) {
            divisor = num[1] - num[0];
        } else {
            divisor = gcd(num[1] - num[0], num[2] - num[1]);
            for (int i = 2; i < n - 1; i++) {
                divisor = gcd(divisor, num[i + 1] - num[i]);
            }
        }
        sb = new StringBuilder();
        getDivisor(divisor);

        System.out.println(sb);
    }

    static void getDivisor(int number) {
        int max = number / 2 + 1;
        for (int i = 2; i < max; i++) {
            if (number % i == 0) {
                sb.append(i).append(" ");
            }
        }
        sb.append(number);
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}