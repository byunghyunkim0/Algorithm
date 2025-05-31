import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[][] board;
    static List<int[][]> keys;
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
        keys = new ArrayList<>();
        keys.add(key);
        for (int i = 0; i < 3; i++) {
            keys.add(getKey(keys.get(i)));
        }
        
        int startX = n + m - 2;
        int startY = n + m - 2;
        int endX = m - 1;
        int endY = m - 1;
        board = new int[n + (2 * (m - 1))][n + (2 * (m - 1))];
        for (int i = m - 1; i < m - 1 + n; i++) {
            for (int j = m - 1; j < m - 1 + n; j++) {
                board[i][j] = lock[i - m + 1][j - m + 1];
                if (board[i][j] == 0) {
                    startX = Math.min(startX, i);
                    startY = Math.min(startY, j);
                    endX = Math.max(endX, i);
                    endY = Math.max(endY, j);
                }
            }
        }
        for (int i = endX - m + 1; i <= startX; i++) {
            for (int j = endY - m + 1; j <= startY; j++) {
                if (check(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean check(int x, int y) {
        k : for (int[][] key : keys) {
            int[][] copy = new int[n + (2 * (m - 1))][n + (2 * (m - 1))];
            for (int i = 0; i < copy.length; i++) {
                copy[i] = board[i].clone();
            }
            for (int i = x; i < x + m; i++) {
                for (int j = y; j < y + m; j++) {
                    copy[i][j] += key[i - x][j - y];
                }
            }
            for (int i = m - 1; i < m - 1 + n; i++) {
                for (int j = m - 1; j < m - 1 + n; j++) {
                    if (copy[i][j] != 1) {
                        continue k;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    static int[][] getKey(int[][] key) {
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = key[m - 1 - j][i];
            }
        }
        return res;
    }
}