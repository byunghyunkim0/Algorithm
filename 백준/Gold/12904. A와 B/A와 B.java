import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A와 B
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        String s = br.readLine();
        String t = br.readLine();
        // when
        int start = 0;
        int end = t.length() - 1;
        boolean reverse = false;
        while (Math.abs(start - end) + 1 != s.length()) {
            if (!reverse) {
                if (t.charAt(end) == 'B') {
                    int temp = end - 1;
                    end = start;
                    start = temp;
                    reverse = true;
                } else {
                    end--;
                }
            } else {
                if (t.charAt(end) == 'B') {
                    int temp = end + 1;
                    end = start;
                    start = temp;
                    reverse = false;
                } else {
                    end++;
                }
            }
        }

        // then
        boolean flag = true;
        if (reverse) {
            for (int i = start; i >= end; i--) {
                if (t.charAt(i) != s.charAt(start - i)) {
                    flag = false;
                    break;
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (t.charAt(i) != s.charAt(i - start)) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}