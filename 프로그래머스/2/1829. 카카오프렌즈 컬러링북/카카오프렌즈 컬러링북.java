import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int x, int y, int[][] picture) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length || visited[nx][ny] || picture[nx][ny] != picture[x][y]) {
                    continue;
                }
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
            count++;
        }
        
        return count;
    }
}