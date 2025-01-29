import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 종점
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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(getTime(st.nextToken()), getTime(st.nextToken()));
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        PriorityQueue<Integer> bus = new PriorityQueue<>();
        int count = 0;
        int cur;
        for (Time t : times) {
            cur = t.start;
            bus.add(t.end);
            while (!bus.isEmpty()) {
                if (bus.peek() > cur) {
                    break;
                }
                bus.remove();
            }
            count = Math.max(count, bus.size());
        }
        System.out.println(count);
    }

    static int getTime(String time) {
        String[] temp = time.split("[:.]");
        int h = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int s = Integer.parseInt(temp[2]);
        int sss = Integer.parseInt(temp[3]);
        return sss + (s + (m + h * 60) * 60) * 1000;
    }
}