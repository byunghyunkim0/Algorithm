class Solution {
    static int answer;
    static int[] tc;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        tc = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < 5; j++) {
                tc[i] += (1 << (q[i][j] - 1));
            }
        }
        dfs(0, -1, 0, n, q, ans);
        return answer;
    }
    
    static void dfs(int val, int idx, int count, int n, int[][] q, int[] ans) {
        if (count == 5) {
            for (int i = 0; i < tc.length; i++) {
                if (Integer.bitCount(val & tc[i]) != ans[i]) {
                    return;
                }
            }
            answer++;
            return;
        }
        for (int i = idx + 1; i < n; i++) {
            dfs(val + (1 << i), i, count + 1, n, q, ans);
        }
    }
}