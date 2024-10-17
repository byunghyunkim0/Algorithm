import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 용액
public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        long sum = Long.MAX_VALUE;
        long[] result = new long[3];

        f : while (start < n - 2) {
            int mid = start + 1;
            int end = n - 1;
            while (mid < end) {
                long temp = arr[start] + arr[mid] + arr[end];
                if (Math.abs(temp) < sum) {
                    sum = Math.abs(temp);
                    result[0] = arr[start];
                    result[1] = arr[mid];
                    result[2] = arr[end];
                    if (sum == 0) {
                        break f;
                    }
                }
                if (temp < 0) {
                    mid++;
                } else {
                    end--;
                }
            }
            start++;
        }
        for (long r : result) {
            System.out.print(r + " ");
        }
    }
}