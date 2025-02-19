import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 꼬인 전깃줄
public class Main {
    static int n;
    static int size;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        arr[0] = Integer.parseInt(st.nextToken());
        size = 1;
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[size - 1] <= num) {
                arr[size++] = num;
                continue;
            }
            arr[search(num)] = num;
        }
        System.out.println(n - size);
    }

    static int search(int num) {
        int start = 0;
        int end = size - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}