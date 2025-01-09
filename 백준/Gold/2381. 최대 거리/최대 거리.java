import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대 거리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int minDif = Integer.MAX_VALUE;
        int maxDif = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            minSum = Math.min(minSum, x + y);
            maxSum = Math.max(maxSum, x + y);
            minDif = Math.min(minDif, x - y);
            maxDif = Math.max(maxDif, x - y);
        }
        System.out.println(Math.max(maxSum - minSum, maxDif - minDif));
    }
}