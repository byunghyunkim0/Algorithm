import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            if (players[i] % m == 0) {
                server[i] = players[i] / m;
            } else {
                server[i] = (players[i] / m) + 1;
            }
        }
        System.out.println(Arrays.toString(server));
        return answer;
    }
}