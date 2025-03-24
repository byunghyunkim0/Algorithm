import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        int[] server = new int[n + k];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                server[i] += server[i - 1];
            }
            int temp = players[i] / m - server[i];
            
            if (temp > 0) {
                server[i + k] -= temp;
                server[i] += temp;
                answer += temp;
            }
        }
        return answer;
    }
}