import java.util.*;

class Solution {
    public static class Point {
        private int x;
        private int y;
        
        public Point() {
            
        }
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static Queue<Point> queue;
    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        Point start = new Point();
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    visited[i][j] = true;
                    start = new Point(i, j);
                }
            }
        }
        
        queue = new LinkedList<>();
        queue.add(start);
        int result = 0;
        l : while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.remove();
                if (map[cur.x][cur.y] == 'G') {
                    answer = result;
                    break l;
                }
                for (int j = 0; j < 4; j++) {
                    move(j, cur.x, cur.y);
                }
            }
            result++;
        }
        return answer;
    }
    
    public static void move(int d, int x, int y) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        while (true) {
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'D') {
                nx -= dx[d];
                ny -= dy[d];
                break;
            }
            nx += dx[d];
            ny += dy[d];
        }
        if (visited[nx][ny]) {
            return;
        }
        queue.add(new Point(nx, ny));
        visited[nx][ny] = true;
    }
}