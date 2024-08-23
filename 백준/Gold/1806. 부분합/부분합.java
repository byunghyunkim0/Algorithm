import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (end <= n) {
            if (sum >= s) {
                result = Math.min(result, end - start);
                sum -= arr[start++];
            } else {
                sum += arr[end++];
            }
        }

        // then
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}