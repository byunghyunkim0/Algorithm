import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// 새로운 게임 2
public class Main {
    static class Chess{
        int idx;
        int x;
        int y;
        int d;
        public Chess(int idx, int x, int y, int d) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static class Board{
        int color;
        Stack<Chess> stack;
        public Board(int color, Stack<Chess> stack) {
            this.color = color;
            this.stack = stack;
        }
    }
    static int n;
    static int k;
    static Chess[] chess;
    static Board[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean find = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Board[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = new Board(Integer.parseInt(st.nextToken()), new Stack<>());
            }
        }

        chess = new Chess[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            chess[i] = new Chess(i, x, y, d);
            map[x][y].stack.add(chess[i]);
        }
        int count = 0;
        while (count <= 1000 && !find) {
            for (Chess c : chess) {
                move(c);
            }
            count++;
        }
        if (find) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    static void move(Chess chess) {
        int nx = chess.x + dx[chess.d];
        int ny = chess.y + dy[chess.d];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny].color == 2) {
            if (chess.d % 2 == 0) {
                chess.d++;
            } else {
                chess.d--;
            }
            nx = chess.x + dx[chess.d];
            ny = chess.y + dy[chess.d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny].color != 2) {
                moveTo(nx, ny, chess);
            }
            return;
        }
        if (map[nx][ny].color != 2) {
            moveTo(nx, ny, chess);
        }
    }

    static void moveTo(int x, int y, Chess chess) {
        if (map[x][y].color == 1) {
            while (true) {
                Chess cur = map[chess.x][chess.y].stack.pop();
                if (cur.idx == chess.idx) {
                    map[x][y].stack.add(cur);
                    break;
                }
                map[x][y].stack.add(cur);
                cur.x = x;
                cur.y = y;
            }
        } else {
            List<Chess> temp = new ArrayList<>();
            while (true) {
                Chess cur = map[chess.x][chess.y].stack.pop();
                if (cur.idx == chess.idx) {
                    temp.add(cur);
                    break;
                }
                temp.add(cur);
                cur.x = x;
                cur.y = y;
            }
            for (int i = temp.size() - 1; i >= 0; i--) {
                map[x][y].stack.add(temp.get(i));
            }
        }
        if (map[x][y].stack.size() >= 4) {
            find = true;
        }
        chess.x = x;
        chess.y = y;
    }
}