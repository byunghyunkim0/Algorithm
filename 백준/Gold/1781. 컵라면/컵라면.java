import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 컵라면
public class Main {
    static class Cup{
        int time;
        int count;
        public Cup(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Cup[] cups = new Cup[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cups[i] = new Cup(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cups, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.count - o1.count;
            }
            return o1.time - o2.time;
        });

        PriorityQueue<Cup> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (int i = 0; i < n; i++) {
            if (cups[i].time > queue.size()) {
                queue.add(cups[i]);
                continue;
            }
            if (!queue.isEmpty() && queue.peek().count < cups[i].count) {
                queue.remove();
                queue.add(cups[i]);
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res += queue.remove().count;
        }
        System.out.println(res);
    }
}