import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 음주 코딩
public class Main {
    static class Segment {
        int[] tree;
        public Segment(int arrSize) {
            int treeSize = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
            tree = new int[1 << (treeSize + 1)];
        }

        public int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }
            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end);
        }

        public int update(int node, int start, int end, int idx, int diff) {
            if (idx < start || idx > end) {
                return tree[node];
            }

            if (start == idx && end == idx) {
                return tree[node] = diff;
            }

            int mid = (start + end) / 2;
            return tree[node] = update(node * 2, start, mid, idx, diff) * update(node * 2 + 1, mid + 1, end, idx, diff);
        }

        public int mul(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 1;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return mul(node * 2, start, mid, left, right) * mul(node * 2 + 1, mid + 1, end, left, right);
        }
    }

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;
        Segment tree;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            tree = new Segment(n);

            st = new StringTokenizer(br.readLine());
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] != 0) {
                    arr[i] /= Math.abs(arr[i]);
                }
            }

            tree.init(1, 1, n);

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String f = st.nextToken();
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                if (f.equals("C")) {
                    if (second != 0) {
                        second /= Math.abs(second);
                    }
                    tree.update(1, 1, n, first, second);
                } else {
                    int res = tree.mul(1, 1, n, first, second);
                    if (res == 1) {
                        sb.append("+");
                    } else if (res == 0) {
                        sb.append(0);
                    } else {
                        sb.append("-");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}