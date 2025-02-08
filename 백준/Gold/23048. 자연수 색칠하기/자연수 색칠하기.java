import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 자연수 색칠하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] paint = new int[n + 1];
        paint[1] = 1;
        int color = 1;

        for (int i = 2; i <= n; i++) {
            if (paint[i] != 0) {
                continue;
            }
            color++;
            for (int j = i; j <= n; j += i) {
                paint[j] = color;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(color).append("\n");
        for (int i = 1; i <= n; i++) {
            sb.append(paint[i]).append(" ");
        }
        System.out.println(sb);
    }
}