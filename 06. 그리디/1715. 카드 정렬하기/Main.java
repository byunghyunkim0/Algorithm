import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        // when
        int result = 0;
        while (queue.size() > 1) {
            int sum = queue.remove() + queue.remove();
            result += sum;
            queue.add(sum);
        }

        // then
        System.out.println(result);
    }
}