import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 호텔
public class Main {
    static class City {
        int cost;
        int customer;
        public City(int cost, int customer) {
            this.cost = cost;
            this.customer = customer;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        City[] cities = new City[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            cities[i] = new City(cost, customer);
        }

        int[] dp = new int[c + 101];
        Arrays.fill(dp, 100000000);
        dp[0] = 0;

        for (City city : cities) {
            for (int i = city.customer; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], city.cost + dp[i - city.customer]);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = c; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }
        System.out.println(res);
    }
}