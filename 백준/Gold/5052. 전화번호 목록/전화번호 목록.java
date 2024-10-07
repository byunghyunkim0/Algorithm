import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 전화번호 목록
public class Main {
    static class Node {
        HashMap<Character, Node> child;
        boolean end;
        public Node () {
            this.child = new HashMap<>();
            this.end = false;
        }
    }

    static class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }
        public void insert(String str) {
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!node.child.containsKey(c)) {
                    node.child.put(c, new Node());
                }
                node = node.child.get(c);
            }
            node.end = true;
        }
        public boolean search(String str) {
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (node.end) {
                    return true;
                }
                if (node.child.containsKey(c)) {
                    node = node.child.get(c);
                } else {
                    return false;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            List<String> number = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                number.add(str);
                trie.insert(str);
            }
            boolean flag = true;
            for (String num : number) {
                if (trie.search(num)) {
                    flag = false;
                }
            }

            if (flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}