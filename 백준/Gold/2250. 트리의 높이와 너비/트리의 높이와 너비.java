import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리의 높이와 너비
public class Main {
    static class Node {
        int left;
        int right;
        int parent;
        public Node() {
            parent = -1;
        }
    }

    static class Width {
        int max;
        int min;
        public Width(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    static Width[] widths;
    static Node[] tree;
    static int depth = 0;
    static int index = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        widths = new Width[n + 1];
        tree = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            widths[i] = new Width(Integer.MIN_VALUE, Integer.MAX_VALUE);
            tree[i] = new Node();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[p].left = l;
            tree[p].right = r;
            if (l != -1) {
                tree[l].parent = p;
            }
            if (r != -1) {
                tree[r].parent = p;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (tree[i].parent == -1) {
                dfs(tree[i], 1);
                break;
            }
        }

        int res = 0;
        int d = 0;
        for (int i = 1; i <= depth; i++) {
            if (res < widths[i].max - widths[i].min + 1) {
                res = widths[i].max - widths[i].min + 1;
                d = i;
            }
        }
        System.out.println(d + " " + res);
    }

    static void dfs(Node cur, int d) {
        depth = Math.max(depth, d);
        if (cur.left != -1) {
            dfs(tree[cur.left], d + 1);
        }
        widths[d].min = Math.min(widths[d].min, index);
        widths[d].max = Math.max(widths[d].max, index++);
        if (cur.right != -1) {
            dfs(tree[cur.right], d + 1);
        }
    }
}