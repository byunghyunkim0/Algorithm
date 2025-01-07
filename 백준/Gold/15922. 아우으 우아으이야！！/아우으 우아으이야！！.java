import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아우으 우아으이야!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x > end) {
                result += end - start;
                start = x;
                end = y;
            } else {
                end = Math.max(end, y);
            }
        }
        System.out.println(result + end - start);
    }
}