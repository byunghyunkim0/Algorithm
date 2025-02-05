import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Meats On The Grill
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            String[] grill = new String[h];

            for (int i = 0; i < h; i++) {
                grill[i] = br.readLine();
            }

            for (int i = h - 1; i >= 0; i--) {
                sb.append(grill[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}