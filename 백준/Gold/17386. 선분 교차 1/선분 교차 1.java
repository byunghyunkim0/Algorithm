import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 선분 교차 1
public class Main {
    static class Point {
        long x;
        long y;
        public Point (long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point p4 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int CCW1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int CCW2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);

        if (CCW1 <= 0 && CCW2 <= 0) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long temp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        if (temp < 0) {
            return -1;
        } else if (temp > 0) {
            return 1;
        }
        return 0;
    }
}