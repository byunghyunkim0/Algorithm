import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2
public class Main {
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // given
        int n = Integer.parseInt(br.readLine());
        arr = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        count = 0;
        for (int i = 0; i < n; i++) {
            // when
            int num = Integer.parseInt(st.nextToken());

            if (arr[count] < num) {
                arr[++count] = num;
            } else {
                int idx = search(num);
                arr[idx] = num;
            }
        }

        // then
        System.out.println(count);
    }

    static int search(int num) {
        int start = 1;
        int end = count;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}