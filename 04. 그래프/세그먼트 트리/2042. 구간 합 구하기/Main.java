import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기
public class Main {
    static long[] tree;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int h = (int)Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int)Math.pow(2, h + 1);
        tree = new long[treeSize];

        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, n - 1, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int fun = Integer.parseInt(st.nextToken());
            // when
            if (fun == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long num = Long.parseLong(st.nextToken());
                Update(0, n - 1, 1, idx, num - arr[idx]);
                arr[idx] = num;
            } else {
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                sb.append(Sum(0, n - 1, 1, start, end)).append("\n");
            }
        }

        // then
        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void Update(int start, int end, int node, int idx, long dif) {
        if (start <= idx && idx <= end) {
            tree[node] += dif;
        } else {
            return;
        }
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        Update(start, mid, node * 2, idx, dif);
        Update(mid + 1, end, node * 2 + 1, idx, dif);
    }

    static long Sum(int start, int end, int node, int idxStart, int idxEnd) {
        if (idxEnd < start || idxStart > end) {
            return 0;
        }
        if (idxStart <= start && end <= idxEnd) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Sum(start, mid, node * 2, idxStart, idxEnd) + Sum(mid + 1, end, node * 2 + 1, idxStart, idxEnd);
    }
}