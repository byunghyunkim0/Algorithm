import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자구슬
public class Main {
    static int[] arr;
    static int[] res;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
        }

        res = new int[m];
        int end = 30000;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (check(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
    static boolean check(int val) {
        int[] temp = new int[m];
        int sum = 0;
        int count = 0;
        int idx = 1;
        for (int i = 0; i < n; i++) {
            if (idx > m) {
                return false;
            }
            if (sum + arr[i] > val || m - idx == n - i) {
                temp[idx - 1] = count;
                idx++;
                count = 1;
                sum = arr[i];
            } else {
                count++;
                sum += arr[i];
            }
        }

        if (idx > m) {
            return false;
        }
        temp[m - 1] = count;
        res = temp.clone();
        return true;
    }
}