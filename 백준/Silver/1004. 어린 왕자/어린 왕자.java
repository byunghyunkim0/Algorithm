import java.util.Scanner;

public class Main {
    static int x1;
    static int x2;
    static int y1;
    static int y2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int result = 0;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();
                result += getDistance(cx, cy, r);
            }
            System.out.println(result);
        }
    }
    public static int getDistance(int x, int y, int r) {
        double dis1 = Math.pow((x - x1), 2) + Math.pow((y - y1), 2);
        double dis2 = Math.pow((x - x2), 2) + Math.pow((y - y2), 2);
        double r2 = Math.pow(r, 2);
        if ((dis1 > r2 && dis2 > r2) || (dis1 < r2 && dis2 < r2)) {
            return 0;
        }
        return 1;
    }
}