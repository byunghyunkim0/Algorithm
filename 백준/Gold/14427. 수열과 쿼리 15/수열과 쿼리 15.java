import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열과 쿼리 15
public class Main {
    static class Segment{
        int[] tree;

        public Segment(int size) {
            int h = (int)Math.ceil(Math.log(size) / Math.log(2));
            int treeSize = 1 << (h + 1);

            tree = new int[treeSize];
        }

        public int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = start;
            }
            int mid = (start + end) / 2;
            return tree[node] = minIndex(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
        }

        public int change(int node, int start, int end, int idx) {
            if (idx < start || end < idx) {
                return tree[node];
            }

            if (start == end) {
                return tree[node] = idx;
            }

            int mid = (start + end) / 2;
            return tree[node] = minIndex(change(node * 2, start, mid, idx), change(node * 2 + 1, mid + 1, end, idx));
        }
        public int minIndex(int a, int b) {
            if (arr[a] == arr[b]) {
                return Math.min(a, b);
            }
            if (arr[a] < arr[b]) {
                return a;
            }
            return b;
        }
    }
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Segment segment = new Segment(n);
        segment.init(1, 1, n);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            if (o == 2) {
                sb.append(segment.tree[1]).append("\n");
                continue;
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
            segment.change(1, 1, n, a);
        }
        System.out.print(sb);
    }
}