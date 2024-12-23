import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 호 안에 수류탄이야!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] point = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        if (n > 1) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < n - 1; i++) {
            if (max < point[i]) {
                break;
            }
            max = Math.max(max, point[i] + Integer.parseInt(st.nextToken()));
        }
        if (max < point[n - 1]) {
            System.out.println("엄마 나 전역 늦어질 것 같아");
            return;
        }
        System.out.println("권병장님, 중대장님이 찾으십니다");
    }
}