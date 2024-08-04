import java.util.Scanner;

public class Main {
    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point p1 = new Point(sc.nextInt(), sc.nextInt());
        Point p2 = new Point(sc.nextInt(), sc.nextInt());
        Point p3 = new Point(sc.nextInt(), sc.nextInt());
        Point p4 = new Point(sc.nextInt(), sc.nextInt());
        int ccw1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int ccw2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
        if (ccw1 == 0 && ccw2 == 0) {
            if (check(p1, p2, p3, p4)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
            return;
        }
        if (ccw1 <= 0 && ccw2 <= 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long temp = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        if (temp > 0) {
            return 1;
        } else if (temp == 0) {
            return 0;
        }
        return -1;
    }

    static boolean check(Point p1, Point p2, Point p3, Point p4) {
        return Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x)
                && Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x)
                && Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y)
                && Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y);
    }
}