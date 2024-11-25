import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 움직이는 미로 탈출
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<char[]> map;
    static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static char[] wall = {'.', '.', '.', '.', '.', '.', '.', '.'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            map.add(br.readLine().toCharArray());
        }

        Point start = new Point(7, 0);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.remove();
                if (map.get(cur.x)[cur.y] == '#') {
                    continue;
                }
                if (cur.x == 0 && cur.y == 7) {
                    System.out.println(1);
                    return;
                }
                for (int d = 0; d < 9; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && map.get(nx)[ny] == '.') {
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            moveWall();
        }
        System.out.println(0);
    }

    static void moveWall() {
        map.remove(7);
        map.add(0, wall);
    }
}