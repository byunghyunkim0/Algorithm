import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 회의실 개수
public class Main {
    static class Time {
        int start;
        int end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        PriorityQueue<Time> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                queue.add(times[i]);
            } else {
                while (!queue.isEmpty() && queue.peek().end <= times[i].start) {
                    queue.remove();
                }
                queue.add(times[i]);
            }
            max = Math.max(queue.size(), max);
        }
        System.out.println(max);
    }
}