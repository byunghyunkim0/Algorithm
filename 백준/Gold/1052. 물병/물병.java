import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계단 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String number = Integer.toBinaryString(n);

        int count = Integer.bitCount(n);
        int result = 0;
        if (count > k) {
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == '1') {
                    k--;
                }
                if (k == 0) {
                    String temp = number.substring(i);
                    result = (1 << temp.length()) - Integer.parseInt(temp, 2);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}