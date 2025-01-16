import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최솟값과 최댓값
public class Main {
    static class Pair{
        int max;
        int min;
        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    static class Segment{
        int[] maxTree;
        int[] minTree;
        public Segment(int arrSize) {
            int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
            maxTree = new int[1 << (h + 1)];
            minTree = new int[1 << (h + 1)];
        }

        public void init(int node, int start, int end) {
            maxInit(node, start, end);
            minInit(node, start, end);
        }

        int maxInit(int node, int start, int end) {
            if (start == end) {
                return maxTree[node] = arr[start];
            }
            int mid = (start + end) / 2;
            return maxTree[node] = Math.max(maxInit(node * 2, start, mid), maxInit(node * 2 + 1, mid + 1, end));
        }

        int minInit(int node, int start, int end) {
            if (start == end) {
                return minTree[node] = arr[start];
            }
            int mid = (start + end) / 2;
            return minTree[node] = Math.min(minInit(node * 2, start, mid), minInit(node * 2 + 1, mid + 1, end));
        }

        Pair search(int node, int start, int end, int left, int right) {
            return new Pair(maxSearch(node, start, end, left, right), minSearch(node, start, end, left, right));
        }

        int maxSearch(int node, int start, int end, int left, int right) {
            if (end < left || start > right) {
                return Integer.MIN_VALUE;
            }

            if (left <= start && end <= right) {
                return maxTree[node];
            }
            int mid = (start + end) / 2;
            return Math.max(maxSearch(node * 2, start, mid, left, right), maxSearch(node * 2 + 1, mid + 1, end, left, right));
        }

        int minSearch(int node, int start, int end, int left, int right) {
            if (end < left || start > right) {
                return Integer.MAX_VALUE;
            }

            if (left <= start && end <= right) {
                return minTree[node];
            }
            int mid = (start + end) / 2;
            return Math.min(minSearch(node * 2, start, mid, left, right), minSearch(node * 2 + 1, mid + 1, end, left, right));
        }
    }
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Segment tree = new Segment(n);
        tree.init(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Pair res = tree.search(1, 1, n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(res.min).append(" ").append(res.max).append("\n");
        }
        System.out.print(sb);
    }
}