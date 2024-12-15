import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 퍼즐
public class Main {
    static final String target = "123456780";
    static HashMap<String, Integer> hashMap;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Node{
        int idx;
        String board;
        public Node(int idx, String board) {
            this.idx = idx;
            this.board = board;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map.append(st.nextToken());
            }
        }
        int idx = map.indexOf("0");

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(idx, map.toString()));

        hashMap = new HashMap<>();
        hashMap.put(map.toString(), 0);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.remove();
                int count = hashMap.get(cur.board);
                int x = cur.idx / 3;
                int y = cur.idx % 3;
                if (cur.board.equals(target)) {
                    System.out.println(count);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                        continue;
                    }
                    int index = nx * 3 + ny;
                    char ch = cur.board.charAt(index);
                    String nextBoard = cur.board.replace(ch, 'a');
                    nextBoard = nextBoard.replace('0', ch);
                    nextBoard = nextBoard.replace('a', '0');

                    if (!hashMap.containsKey(nextBoard)) {
                        queue.add(new Node(index, nextBoard));
                        hashMap.put(nextBoard, count + 1);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}