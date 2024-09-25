import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나머지 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // given
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        int[] mod = new int[m];
        mod[0] = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % m;
            mod[sum[i]]++;
        }

        // when
        long count = 0;
        for (int i = 0; i < m; i++) {
            count += (long)mod[i] * (mod[i] - 1) / 2;
        }

        // then
        System.out.println(count);
    }
}