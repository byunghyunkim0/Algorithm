class Solution {
    static int[] map;
    static int answer;
    static boolean[] visited;
    public int solution(int n) {
        answer = 0;
        map = new int[n];
        visited = new boolean[n];
        
        dfs(0, n);
        return answer;
    }
    
    static void dfs(int c, int n) {
        if (c == n) {
            answer++;
            return;
        }
        f : for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            for (int j = 0; j < c; j++) {
                if (j - map[j] == c - i || j + map[j] == c + i) {
					continue f;
				}
            }
            
            map[c] = i;
            visited[i] = true;
            dfs(c + 1, n);
            visited[i] = false;
        }
    }
    
}