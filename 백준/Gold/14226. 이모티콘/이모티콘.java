import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 이모티콘
public class Main {
    static class Node {
        int count;
        int board;
        public Node (int count, int board) {
            this.count = count;
            this.board = board;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[2001][2001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1][0] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.remove();
                if (cur.count == s) {
                    System.out.println(time);
                    return;
                }

                if (cur.count <= 0) {
                    continue;
                }

                if (!visited[cur.count][cur.count]) {
                    queue.add(new Node(cur.count, cur.count));
                    visited[cur.count][cur.count] = true;
                }

                if (cur.count + cur.board < 2000 && !visited[cur.count + cur.board][cur.board]) {
                    queue.add(new Node(cur.count + cur.board, cur.board));
                    visited[cur.count + cur.board][cur.board] = true;
                }

                if (!visited[cur.count - 1][cur.board]) {
                    queue.add(new Node(cur.count - 1, cur.board));
                    visited[cur.count - 1][cur.board] = true;
                }
            }
            time++;
        }
    }
}