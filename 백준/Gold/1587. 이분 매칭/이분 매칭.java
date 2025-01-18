import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분 매칭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int result = na / 2 + nb / 2;
        if (na % 2 == 0 || nb % 2 == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a % 2 == 1 && b % 2 == 1) {
                result++;
                break;
            }
        }
        System.out.println(result);
    }
}