import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 반도체 설계
public class Main {
    static int n;
    static int[] arr;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis = new int[n];

        lis[0] = arr[0];
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (lis[j] < arr[i]) {
                lis[j + 1] = arr[i];
                j++;
                continue;
            }
            int idx = search(0, j, arr[i]);
            lis[idx] = arr[i];
        }
        System.out.println(j + 1);
    }

    static int search(int start, int end, int target) {
        int mid;

        while (start < end) {
            mid = (start + end) / 2;
            if (lis[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}