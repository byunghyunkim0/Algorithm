import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 중앙값 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int m = Integer.parseInt(br.readLine());
            sb.append((m + 1) / 2).append("\n");

            int[] arr = new int[m];

            for (int i = 0; i < m / 10; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 10; j++) {
                    arr[i * 10 + j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int i = m - (m % 10); i < m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
            PriorityQueue<Integer> right = new PriorityQueue<>();
            int median = arr[0];
            sb.append(median).append(" ");
            for (int i = 1; i < m; i++) {
                if (left.size() == right.size()) {
                    if (arr[i] > median) {
                        right.add(arr[i]);
                        left.add(median);
                        median = right.remove();
                    } else {
                        left.add(arr[i]);
                    }
                    continue;
                }
                if (arr[i] > median) {
                    right.add(arr[i]);
                } else {
                    right.add(median);
                    left.add(arr[i]);
                    median = left.remove();
                }
                sb.append(median).append(" ");
                if ((i + 2) % 20 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}