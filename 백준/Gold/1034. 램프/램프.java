import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 램프
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            int zero = 0;
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    zero++;
                }
            }
            int count = 0;
            if (zero <= k && zero % 2 == k % 2) {
                f : for (int j = i; j < n; j++) {
                    for (int l = 0; l < m; l++) {
                        if (map[j][l] != map[i][l]) {
                            continue f;
                        }
                    }
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        System.out.println(result);
    }
}