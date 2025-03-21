import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static Money[] dp;
    static class Money {
        int doSelect;
        int noSelect;
        public Money() {
        }
    }
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        
        for (int i = 0; i <= sales.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] link : links) {
            graph.get(link[0]).add(link[1]);
        }
        
        dp = new Money[sales.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new Money();
        }
        
        dfs(sales, 1);
        
        return Math.min(dp[1].doSelect, dp[1].noSelect);
    }
    
    static void dfs(int[] sales, int index) {
        if (graph.get(index).isEmpty()) {
            dp[index].doSelect += sales[index - 1];
            return;
        }
        
        boolean flag = false;
        for (int next : graph.get(index)) {
            dfs(sales, next);
            if (dp[next].doSelect <= dp[next].noSelect) {
                dp[index].doSelect += dp[next].doSelect;
                flag = true;
            } else {
                dp[index].doSelect += dp[next].noSelect;
            }
        }
        
        if (flag) {
            dp[index].noSelect = dp[index].doSelect;
            dp[index].doSelect += sales[index - 1];
            return;
        }
        
        dp[index].noSelect = Integer.MAX_VALUE;
        for (int next : graph.get(index)) {
            dp[index].noSelect = Math.min(dp[index].noSelect, dp[index].doSelect + dp[next].doSelect - dp[next].noSelect);
        }
        dp[index].doSelect += sales[index - 1];
    }
}