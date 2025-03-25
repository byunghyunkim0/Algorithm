import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리
public class Main {
    static int[] in;
    static int[] pre;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            pre = new int[n + 1];
            in = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }
            post(0, 0, n);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void post(int root, int start, int end) {
        int r = pre[root];
        for (int i = start; i < end; i++) {
            if (r == in[i]) {
                post(root + 1, start, i);
                post(root + i - start + 1, i + 1, end);
                sb.append(r).append(" ");
            }
        }
    }
}