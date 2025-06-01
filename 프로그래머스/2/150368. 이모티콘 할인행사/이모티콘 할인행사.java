import java.util.*;

class Solution {
    static int[] discounts;
    static int n;
    static int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        answer = new int[2];
        discounts = new int[n];
        for (int i = 0; i < n; i++) {
            emoticons[i] /= 100;
        }
        bfs(users, emoticons, 0, 0);
        return answer;
    }
    
    static void bfs(int[][] users, int[] emoticons, int idx, int c) {
        if (c == n) {
            int count = 0;
            int sum = 0;
            int[] price = new int[users.length];
            for (int i = 0; i < users.length; i++) {
                for (int j = 0; j < n; j++) {
                    if (users[i][0] > discounts[j]) {
                        continue;
                    }
                    price[i] += emoticons[j] * (100 - discounts[j]);
                }
            }
            
            for (int i = 0; i < users.length; i++) {
                if (price[i] >= users[i][1]) {
                    count++;
                    continue;
                }
                sum += price[i];
            }
            
            if (answer[0] < count) {
                answer[0] = count;
                answer[1] = sum;
            } else if (answer[0] == count) {
                answer[1] = Math.max(sum, answer[1]);
            }
            return;
        }
        for (int i = 10; i <= 40; i += 10) {
            discounts[idx] = i;
            bfs(users, emoticons, idx + 1, c + 1);
        }
    }
}