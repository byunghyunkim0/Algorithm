import java.util.*;

class Solution {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] max;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        max = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                getOil(land, i, j);
            }
        }
        for (int m : max) {
            answer = Math.max(answer, m);
        }
        return answer;
    }
    
    static void getOil(int[][] land, int x, int y) {
        Set<Integer> set = new HashSet<>();
        set.add(y);
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || land[nx][ny] == 0) {
                    continue;
                }
                set.add(ny);
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                count++;
            }
        }
        
        for (int c : set) {
            max[c] += count;
        }
    }
}