import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기업투자
public class Main {
    static class Invest {
        int money;
        int[] company = new int[21];
        public Invest(int money) {
            this.money = money;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] money = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= m; j++) {
                money[idx][j] = Integer.parseInt(st.nextToken());
            }
        }

        Invest[][][] invests = new Invest[n + 1][m + 1][2];
        for (int j = 0; j <= m; j++) {
            for (int i = 0; i <= n; i++) {

                if (i == 0 || j == 0) {
                    invests[i][j][0] = new Invest(0);
                    invests[i][j][1] = new Invest(0);
                    continue;
                }

                if (invests[i][j - 1][0].money > invests[i][j - 1][1].money) {
                    invests[i][j][1] = new Invest(invests[i][j - 1][0].money);
                    invests[i][j][1].company = invests[i][j - 1][0].company.clone();
                } else {
                    invests[i][j][1] = new Invest(invests[i][j - 1][1].money);
                    invests[i][j][1].company = invests[i][j - 1][1].company.clone();
                }

                int temp = money[i][j];
                int idx = 0;
                for (int k = 1; k <= i; k++) {
                    if (temp < invests[k][j][1].money + money[i - k][j]) {
                        temp = invests[k][j][1].money + money[i - k][j];
                        idx = k;
                    }
                }
                invests[i][j][0] = new Invest(temp);
                invests[i][j][0].company = invests[idx][j - 1][0].company.clone();
                invests[i][j][0].company[j] += i - idx;
            }
        }
        if (invests[n][m][0].money > invests[n][m][1].money) {
            System.out.println(invests[n][m][0].money);
            for (int i = 1; i <= m; i++) {
                System.out.print(invests[n][m][0].company[i] + " ");
            }
        } else {
            System.out.println(invests[n][m][1].money);
            for (int i = 1; i <= m; i++) {
                System.out.print(invests[n][m][1].company[i] + " ");
            }
        }
    }
}