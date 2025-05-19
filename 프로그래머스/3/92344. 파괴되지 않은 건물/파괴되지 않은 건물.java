import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] imos = new int[n + 1][m + 1];
        for (int[] s : skill) {
            int degree = s[5];
            if (s[0] == 1) {
                degree *= -1;
            }
            imos[s[1]][s[2]] += degree;
            imos[s[1]][s[4] + 1] += degree * -1;
            imos[s[3] + 1][s[2]] += degree * -1;
            imos[s[3] + 1][s[4] + 1] += degree;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                imos[i][j] += imos[i][j - 1];
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                imos[i][j] += imos[i - 1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + imos[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}