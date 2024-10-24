import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 개미굴
public class Main {
    static class Trie {
        Node root;

        public Trie () {
            this.root = new Node();
        }

        public void insert(String[] str) {
            Node node = this.root;
            for (String cur : str) {
                node.child.putIfAbsent(cur, new Node());
                node = node.child.get(cur);
            }
            node.end = true;
        }
    }
    static class Node {
        TreeMap<String, Node> child;
        boolean end;

        public Node () {
            this.child = new TreeMap<>((o1, o2) -> {
                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return o1.length() - o2.length();
            });
            this.end = false;
        }
    }
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] str = new String[k];
            for (int j = 0; j < k; j++) {
                str[j] = st.nextToken();
            }
            trie.insert(str);
        }
        sb = new StringBuilder();
        dfs(trie.root, 0);
        System.out.print(sb);
    }

    static void dfs(Node node, int depth) {
        TreeMap<String, Node> cur = node.child;
        for (Entry<String, Node> entry : cur.entrySet()) {
            sb.append("--".repeat(depth)).append(entry.getKey()).append("\n");
            if (entry.getValue().end) {
                continue;
            }
            dfs(entry.getValue(), depth + 1);
        }
    }
}