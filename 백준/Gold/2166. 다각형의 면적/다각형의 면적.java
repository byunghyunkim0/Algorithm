import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다각형의 면적
public class Main {
    static class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        Point[] points = new Point[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }
        points[n] = points[0];

        // when
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += points[i].x * points[i + 1].y - points[i].y * points[i + 1].x;
        }
        result = Math.abs(result / 2);

        // then
        System.out.printf("%.1f", result);
    }
}