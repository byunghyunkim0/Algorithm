import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static class Car {
        int x;
        int y;
        int dir;
        int cost;
        public Car (int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    static int n;
    static int[][][] dp;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        n = board.length;
        dp = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Car> queue = new LinkedList<>();
        queue.add(new Car(0, 0, 0, 0));
        queue.add(new Car(0, 0, 2, 0));
        
        while (!queue.isEmpty()) {
            Car cur = queue.remove();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                int temp = 0;
                if (cur.dir == d) {
                    temp = 100;
                } else {
                    temp = 600;
                }
                int c = cur.cost + temp;
                
                if (isRange(nx, ny) || board[nx][ny] == 1 || dp[nx][ny][d] <= c) {
                    continue;
                }
                dp[nx][ny][d] = c;
                queue.add(new Car(nx, ny, d, c));
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dp[n - 1][n - 1][i]);
        }
        return answer;
    }
    
    boolean isRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}