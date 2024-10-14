import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//
public class Main {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        lis = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int index = search(idx, num);
            if (idx == index) {
                lis[idx++] = num;
            } else {
                lis[index] = num;
            }
        }

        System.out.println(n - idx);
    }

    static int search(int e, int number) {
        int start = 0;
        int end = e;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (lis[mid] > number) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}