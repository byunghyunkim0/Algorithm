import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 선분 덮기
public class Main {
    static class Point{
        int start;
        int end;
        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == 0 && end == 0) {
                break;
            }
            if (end <= 0 || start > m) {
                continue;
            }
            points.add(new Point(start, end));
        }
        points.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }
            return o1.start - o2.start;
        });
        int start = 0;
        int cur = 0;
        int result = 0;
        int idx = 0;
        while (start < m) {
            boolean temp = false;
            for (int i = idx; i < points.size(); i++) {
                if (points.get(i).start > start) {
                    break;
                }
                if (points.get(i).start <= start && cur < points.get(i).end) {
                    cur = points.get(i).end;
                    idx = i + 1;
                    temp = true;
                }
            }
            if (temp) {
                start = cur;
                result++;
            } else {
                break;
            }
        }
        if (cur < m) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}