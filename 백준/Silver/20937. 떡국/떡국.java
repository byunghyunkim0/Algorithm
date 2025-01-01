import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 떡국
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[50001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(st.nextToken())]++;
        }
        int result = 0;
        for (int i = 1; i <= 50000; i++) {
            result = Math.max(result, count[i]);
        }
        System.out.println(result);
    }
}