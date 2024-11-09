import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 소문난 칠공주
public class Main {
    static char[][] map;
    static int[] select;
    static class Point {
        int x;
        int y;
        public Point() {

        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        select = new int[25];
        for (int i = select.length - 1; i >= 18; i--) {
            select[i] = 1;
        }
        int result = 0;
        do {
            if (check()) {
                result++;
            }
        } while (np());
        System.out.println(result);
    }

    static boolean check() {
        boolean[][] visited = new boolean[5][5];
        Point start = new Point();
        for (int i = 0; i < 25; i++) {
            if (select[i] == 1) {
                start.x = i / 5;
                start.y = i % 5;
            }
        }
        int countP = 1;
        int countS = 0;
        if (map[start.x][start.y] == 'S') {
            countS++;
        }
        visited[start.x][start.y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                if (!visited[nx][ny] && select[nx * 5 + ny] == 1) {
                    if (map[nx][ny] == 'S') {
                        countS++;
                    }
                    countP++;
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return countP == 7 && countS >= 4;
    }

    static boolean np() {
        int i = select.length - 1;
        int j = i;
        int k = i;

        while (i > 0 && select[i - 1] >= select[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        while (select[i - 1] >= select[j]) {
            j--;
        }
        swap(i - 1, j);
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    static void swap(int a, int b) {
        int temp = select[a];
        select[a] = select[b];
        select[b] = temp;
    }
}