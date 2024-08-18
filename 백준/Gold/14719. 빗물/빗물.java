import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] map = new int[w];
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int result = 0;
        int[][] max = new int[w][2];
        for (int i = 0; i < w - 1; i++) {
            max[i + 1][0] = Math.max(max[i][0], map[i]);
        }
        for (int i = w - 1; i > 0; i--) {
            max[i - 1][1] = Math.max(max[i][1], map[i]);
        }
        for (int i = 0; i < w; i++) {
            if (max[i][0] > map[i] && max[i][1] > map[i]) {
                result += Math.min(max[i][0], max[i][1]) - map[i];
            }
        }

        // then
        System.out.println(result);
    }
}