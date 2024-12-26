import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 흙길 보수하기
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o.start));

        int cur = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (points[i].end < cur) {
                continue;
            }
            if (cur < points[i].start) {
                cur = points[i].start;
            }
            int temp = (points[i].end - cur) / l;
            result += temp;
            cur += temp * l;
            if (cur < points[i].end) {
                cur += l;
                result++;
            }
        }
        System.out.println(result);
    }
}