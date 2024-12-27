import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 커피숍2
public class Main {
    static class Segment{
        long[] tree;

        Segment(int arrSize) {
            int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
            int treeSize = 1 << (h + 1);
            tree = new long[treeSize];
        }

        long init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }
            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
        }

        long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
        }

        long update(int node, int start, int end, int idx, long diff) {
            if (idx < start || end < idx) {
                return tree[node];
            }
            if (start == idx && end == idx) {
                return tree[node] = diff;
            }
            int mid = (start + end) / 2;
            return tree[node] = update(node * 2, start, mid, idx, diff) + update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Segment segment = new Segment(n);
        segment.init(1, 1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (x > y) {
                int temp = y;
                y = x;
                x = temp;
            }
            sb.append(segment.sum(1, 1, n, x, y)).append("\n");
            arr[a] = b;
            segment.update(1, 1, n, a, b);
        }
        System.out.print(sb);
    }
}