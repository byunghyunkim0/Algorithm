import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 단어 수학
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int n = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            // when
            for (int j = 0; j < temp.length(); j++) {
                alpha[temp.charAt(j) - 'A'] += (int)Math.pow(10, temp.length() - j - 1);
            }
        }

        Arrays.sort(alpha);

        int result = 0;
        int index = 25;
        while (alpha[index] != 0) {
            result += (index - 16) * alpha[index--];
        }

        // then
        System.out.println(result);
    }
}