import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 너 봄에는 캡사이신이 맛있단다
public class Main {
    static final int INF = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % INF;
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (num[i] * power[i]) - (num[i] * power[n - i - 1]);
            result %= INF;
        }
        System.out.println(result);
    }
}