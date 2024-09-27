import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팰린드롬?
public class Main {
    static int n;
    static int[] arr;
    static boolean[][] palindrome;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // when
        palindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                palindrome[i][j] = check(i, j);
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            // then
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if (palindrome[s][e]) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean check(int start, int end) {
        while (start <= end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }
}