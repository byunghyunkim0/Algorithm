import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 철로
public class Main {
    static class Point {
        int s;
        int e;
        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Point[] data = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            data[i] = new Point(Math.min(h, o), Math.max(h, o));
        }
        int d = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for (Point p : data) {
            if (p.e - p.s > d) {
                continue;
            }
            list.add(p);
        }
        list.sort((o1, o2) -> {
            if (o1.e == o2.e) {
                return o1.s - o2.s;
            }
            return o1.e - o2.e;
        });
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Point p : list) {
            queue.add(p.s);
            while (!queue.isEmpty()) {
                if (p.e - queue.peek() <= d) {
                    break;
                }
                queue.remove();
            }
            result = Math.max(result, queue.size());
        }
        System.out.println(result);
    }
}