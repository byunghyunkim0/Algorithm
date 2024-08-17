import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int t = Integer.parseInt(st.nextToken());
        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Point[] store = new Point[n];

            st = new StringTokenizer(br.readLine());
            Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            Point dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // when
            boolean[] visited = new boolean[n];
            Queue<Point> queue = new LinkedList<>();
            queue.add(home);
            boolean flag = false;
            while (!queue.isEmpty() && !flag) {
                Point cur = queue.remove();
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && getDistance(cur, store[i])) {
                        visited[i] = true;
                        queue.add(store[i]);
                    }
                }
                if (getDistance(cur, dest)) {
                    flag = true;
                }
            }

            // then
            if (flag) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    static boolean getDistance(Point cur, Point dest) {
        return Math.abs(cur.x - dest.x) + Math.abs(cur.y - dest.y) <= 1000;
    }
}