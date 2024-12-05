import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수3
public class Main {
    public static long[][] matrix = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n < 2) {
            System.out.println(n);
            return;
        }
        long[][] r = pow(n - 1);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                r[i][j] = r[i][j] % 1_000_000;
            }
        }
        System.out.println(r[0][0]);
    }

    static long[][] pow(long n){
        if (n == 1) {
            return matrix;
        }

        long[][] fibo = pow(n / 2);

        if (n % 2 == 0) {
            return mul(fibo, fibo);
        } else {
            return mul(fibo, mul(fibo, matrix));
        }
    }

    static long[][] mul(long[][] a, long[][] b){
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] = result[i][j] % 1_000_000;
            }
        }
        return result;
    }
}