import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경비원
public class Main {
    static class Point{
        int d;
        int idx;
        public Point(int d, int idx) {
            this.d = d;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        Point[] stores = new Point[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        Point cur = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int result = 0;
        for (Point store : stores) {
            if (cur.d == store.d) {
                result += Math.abs(cur.idx - store.idx);
            } else if (cur.d == 1) {
                if (store.d == 3) {
                    result += cur.idx + store.idx;
                } else if (store.d == 4) {
                    result += m - cur.idx + store.idx;
                } else {
                    result += Math.min(cur.idx + n + store.idx, m - cur.idx + m + n - store.idx);
                }
            } else if (cur.d == 2) {
                if (store.d == 1) {
                    result += Math.min(cur.idx + n + store.idx, m - cur.idx + m + n - store.idx);
                } else if (store.d == 3) {
                    result += cur.idx + n - store.idx;
                } else {
                    result += m - cur.idx + n - store.idx;
                }
            } else if (cur.d == 3) {
                if (store.d == 1) {
                    result += cur.idx + store.idx;
                } else if (store.d == 2) {
                    result += n - cur.idx + store.idx;
                } else {
                    result += Math.min(cur.idx + m + store.idx, n - cur.idx + m + n - store.idx);
                }
            } else {
                if (store.d == 1) {
                    result += cur.idx + m - store.idx;
                } else if (store.d == 2) {
                    result += m - store.idx + n - cur.idx;
                } else {
                    result += Math.min(cur.idx + m + store.idx, m + n - cur.idx + n - store.idx);
                }
            }
        }
        System.out.println(result);
    }
}