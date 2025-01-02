import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 인기도 조사
public class Main {
    static final int max = 60 * 60 * 24;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] count = new long[60 * 60 * 24 + 1];

        for (int i = 0; i < n; i++) {
            String time = br.readLine();
            int start = getTime(time.substring(0, 8));
            int end = getTime(time.substring(11));
            if (start > end) {
                count[start]++;
                count[max]--;
                count[0]++;
                count[end + 1]--;
                continue;
            }
            count[start]++;
            count[end + 1]--;
        }

        long temp = count[0];
        for (int i = 1; i < count.length; i++) {
            temp += count[i];
            count[i] = count[i - 1] + temp;
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String time = br.readLine();
            int start = getTime(time.substring(0, 8));
            int end = getTime(time.substring(11));
            long result;
            int t = end - start + 1;
            if (start == 0) {
                result = count[end];
            } else {
                if (start > end) {
                    result = count[max] - count[start - 1] + count[end];
                    t = max - start + end + 1;
                } else {
                    result = count[end] - count[start - 1];
                }
            }
            sb.append((double)result / t).append("\n");
        }
        System.out.println(sb);
    }

    static int getTime(String time) {
        String[] temp = time.split(":");
        int h = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int s = Integer.parseInt(temp[2]);
        return h * 3600 + m * 60 + s;
    }
}