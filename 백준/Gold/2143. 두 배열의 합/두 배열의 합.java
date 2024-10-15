import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 두 배열의 합
public class Main {
    static int[] a;
    static int[] b;
    static int t;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = b[i - 1] + Integer.parseInt(st.nextToken());
        }

        long result = getResult();
        System.out.println(result);
    }

    private static long getResult() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                int sum = b[i] - b[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int sum = t - (a[i] - a[j]);
                if (map.containsKey(sum)) {
                    result += map.get(sum);
                }
            }
        }
        return result;
    }
}