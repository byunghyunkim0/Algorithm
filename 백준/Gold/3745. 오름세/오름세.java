import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오름세
public class Main {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input.trim());
            int size = 0;
            lis = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (size == 0 || lis[size - 1] < num) {
                    lis[size++] = num;
                    continue;
                }
                lis[getIdx(num, size)] = num;
            }
            sb.append(size).append("\n");
        }
        System.out.print(sb);
    }

    static int getIdx(int val, int end) {
        int s = 0;
        int e = end;
        int mid;

        while (s < e) {
            mid = (s + e) / 2;
            if (lis[mid] < val) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return e;
    }
}