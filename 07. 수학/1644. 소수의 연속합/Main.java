import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수의 연속합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2 * i; j <= n; j += i) {
                check[j] = true;
            }
        }

        if (n == 3 || n == 2) {
            System.out.println(1);
            return;
        } else if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] prime = new int[n];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (!check[i]) {
                prime[++index] = i;
            }
        }

        int count = 0;
        int start = 1;
        int end = 1;
        int value = 2;
        while (end <= index) {
            if (value < n) {
                value += prime[++end];
            } else if (value == n) {
                count++;
                value += prime[++end] - prime[start++];
            } else {
                value -= prime[start++];
            }
        }

        System.out.println(count);
    }
}