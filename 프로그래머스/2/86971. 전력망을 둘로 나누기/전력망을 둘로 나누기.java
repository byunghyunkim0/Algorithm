class Solution {
    static int[] parent;
    public int solution(int n, int[][] wires) {
        int answer = 200;
        for (int i = 0; i < wires.length; i++) {
            parent = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                parent[j] = j;
            }
            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }
                union(wires[j][0], wires[j][1]);
            }
            for (int j = 1; j <= n; j++) {
                parent[j] = find(j);
            }
            int temp = 1;
            for (int j = 2; j <= n; j++) {
                if (parent[j] != parent[1]) {
                    temp--;
                } else {
                    temp++;
                }
            }
            answer = Math.min(Math.abs(temp), answer);
        }
        return answer;
    }
    
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}