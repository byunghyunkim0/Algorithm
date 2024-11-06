import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 양팔저울
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] searchW = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            searchW[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[40001];
        List<Integer> checkW = new ArrayList<>();
        for (int weight : weights) {
            int size = checkW.size();
            for (int i = 0; i < size; i++) {
                int cur = checkW.get(i);
                if (!dp[cur + weight]) {
                    checkW.add(cur + weight);
                    dp[cur + weight] = true;
                }
                int temp = Math.abs(cur - weight);
                if (!dp[temp]) {
                    checkW.add(temp);
                    dp[temp] = true;
                }
            }
            if (!dp[weight]) {
                checkW.add(weight);
                dp[weight] = true;
            }
        }

        for (int search : searchW) {
            if (dp[search]) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}