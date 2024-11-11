import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 과제
public class Main {
    static class Task {
        int day;
        int score;
        public Task(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tasks.add(new Task(d, w));
        }

        tasks.sort(Comparator.comparingInt(o -> o.day));
        PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.score));
        pq.add(tasks.get(0));
        for (int i = 1; i < n; i++) {
            Task cur = tasks.get(i);
            if (pq.size() < cur.day) {
                pq.add(cur);
                continue;
            }
            if (!pq.isEmpty() && pq.peek().score < cur.score) {
                pq.remove();
                pq.add(cur);
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.remove().score;
        }

        System.out.println(result);
    }
}