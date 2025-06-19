import java.util.*;

class Solution {
    static class Node {
        int node;
        int x;
        int y;
        Node left;
        Node right;
        public Node (int node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    
    static class Tree {
        Node root;
        List<Integer> prefix = new ArrayList<>();
        List<Integer> postfix = new ArrayList<>();
        public Tree(Node root) {
            this.root = root;
        }
        
        public void add(Node node) {
            Node cur = this.root;
            while (true) {
                if (cur.x < node.x) {
                    if (cur.right == null) {
                        cur.right = node;
                        break;
                    }
                    cur = cur.right;
                } else {
                    if (cur.left == null) {
                        cur.left = node;
                        break;
                    }
                    cur = cur.left;
                }
            }
        }
        
        public int[] getPrefix() {
            makePrefix(root);
            int[] res = new int[prefix.size()];
            for (int i = 0; i < prefix.size(); i++) {
                res[i] = prefix.get(i);
            }
            return res;
        }
        
        public void makePrefix(Node cur) {
            prefix.add(cur.node);
            if (cur.left != null) {
                makePrefix(cur.left);
            }
            if (cur.right != null) {
                makePrefix(cur.right);
            }
        }
        
        public int[] getPostfix() {
            makePostfix(root);
            int[] res = new int[postfix.size()];
            for (int i = 0; i < postfix.size(); i++) {
                res[i] = postfix.get(i);
            }
            return res;
        }
        
        public void makePostfix(Node cur) {
            if (cur.left != null) {
                makePostfix(cur.left);
            }
            if (cur.right != null) {
                makePostfix(cur.right);
            }
            postfix.add(cur.node);
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });
        Tree tree = new Tree(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            tree.add(nodes[i]);
        }
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = tree.getPrefix();
        answer[1] = tree.getPostfix();
        return answer;
    }
}