import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 가운데를 말해요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int n = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        int median = Integer.parseInt(br.readLine());
        sb.append(median).append("\n");

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            // when
            int num = Integer.parseInt(br.readLine());
            if (right.size() == left.size()) {
                if (median > num) {
                    right.add(median);
                    left.add(num);
                    median = left.remove();
                } else {
                    right.add(num);
                }
            } else {
                if (median > num) {
                    left.add(num);
                } else {
                    left.add(median);
                    right.add(num);
                    median = right.remove();
                }
            }
            sb.append(median).append("\n");
        }

        // then
        System.out.println(sb);
    }
}