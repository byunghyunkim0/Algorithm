import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 과일 탕후루
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int result = 0;
        int[] count = new int[10];
        int start = 0;
        int end = 0;

        while (start < n) {
            while (end < n) {
                count[arr[end]]++;
                int temp = 0;
                for (int i = 0; i < 10; i++) {
                    if (count[i] > 0) {
                        temp++;
                    }
                }
                if (temp > 2) {
                    count[arr[end]]--;
                    break;
                } else {
                    result = Math.max(result, end - start + 1);
                    end++;
                }
            }
            count[arr[start++]]--;
        }

        // then
        System.out.println(result);
    }
}