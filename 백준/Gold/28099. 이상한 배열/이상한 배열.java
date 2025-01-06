import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 이상한 배열
public class Main {
    static class Segment{
        int[] tree;
        public Segment(int arrSize) {
            int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
            tree = new int[1 << (h + 1)];
        }

        public int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }
            int mid = (start + end) / 2;
            return tree[node] = Math.max(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
        }

        public int max(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return Math.max(max(node * 2, start, mid, left, right), max(node * 2 + 1, mid + 1, end, left, right));
        }
    }

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> index;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Segment tree = new Segment(n);
            tree.init(1, 0, n - 1);
            index = new HashMap<>();
            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (index.containsKey(arr[i])) {
                    int max = tree.max(1, 0, n - 1, index.get(arr[i]), i);
                    if (max != arr[i]) {
                        check = false;
                    }
                    continue;
                }
                index.put(arr[i], i);
            }
            if (check) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        System.out.print(sb);
    }
}