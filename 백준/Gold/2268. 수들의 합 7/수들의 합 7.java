import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 7
public class Main {
    static class Segment{
        long[] tree;
        public Segment(int arrSize) {
            int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
            tree = new long[1 << (h + 1)];
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (end < left || right < start) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
        }

        public long update(int node, int start, int end, int idx, long val) {
            if (idx < start || end < idx) {
                return tree[node];
            }
            if (start == idx && end == idx) {
                return tree[node] = val;
            }
            int mid = (start + end) / 2;
            return tree[node] = update(node * 2, start, mid, idx, val) + update(node * 2 + 1, mid + 1, end, idx, val);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Segment segment = new Segment(n);
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (f == 0) {
                sb.append(segment.sum(1, 1, n, Math.min(i, j), Math.max(i, j))).append("\n");
                continue;
            }
            segment.update(1, 1, n, i, j);
        }
        System.out.print(sb);
    }
}