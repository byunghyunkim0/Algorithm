import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        boolean[] visited = new boolean[10001];
        int[] dp = new int[topping.length];
        int count = 0;
        for (int i = 0; i < topping.length; i++){
            if (!visited[topping[i]]){
                visited[topping[i]] = true;
                count++;
            }
            dp[i] = count;
        }
        visited = new boolean[10001];
        count = 0;
        for (int i = topping.length - 1; i > 0; i--){
            if (!visited[topping[i]]){
                visited[topping[i]] = true;
                count++;
            }
            if (count == dp[i - 1]){
                answer++;
            }
        }
        return answer;
    }
}