import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가르침
public class Main {
    static int n;
    static int k;
    static int result;
    static int[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int alpha = 0;
        char[] temp = {'a', 'c', 'i', 'n', 't'};
        for (char c : temp) {
            alpha |= 1 << (c - 'a');
        }

        words = new int[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                words[i] |= 1 << (str.charAt(j) - 'a');
            }
        }
        result = 0;

        if (k < 5) {
            System.out.println(result);
            return;
        }
        dfs(0, 5, alpha);

        System.out.println(result);
    }

    static void dfs (int idx, int count, int alpha) {
        if (count == k) {
            int temp = 0;
            for (int word : words) {
                if ((alpha & word) == word) {
                    temp++;
                }
            }
            result = Math.max(result, temp);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if ((alpha & (1 << i)) == 0) {
                dfs(i + 1, count + 1, alpha | (1 << i));
            }
        }
    }
}