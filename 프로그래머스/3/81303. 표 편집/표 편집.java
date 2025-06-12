import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        Stack<Integer> deletes = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        
        int cur = k;
        
        for (String c : cmd) {
            String[] temp = c.split(" ");
            char f = temp[0].charAt(0);
            if (f == 'U') {
                int x = Integer.parseInt(temp[1]);
                for (int i = 0; i < x; i++) {
                    cur = pre[cur];
                }
            } else if (f == 'D') {
                int x = Integer.parseInt(temp[1]);
                for (int i = 0; i < x; i++) {
                    cur = next[cur];
                }
            } else if (f == 'C') {
                deletes.add(cur);
                if (pre[cur] != -1) {
                    next[pre[cur]] = next[cur];
                }
                if (next[cur] != -1) {
                    pre[next[cur]] = pre[cur];
                }
                if (next[cur] == -1) {
                    cur = pre[cur];
                } else {
                    cur = next[cur];
                }
            } else {
                int idx = deletes.pop();
                if (next[idx] != -1) {
                    pre[next[idx]] = idx;
                }
                if (pre[idx] != -1) {
                    next[pre[idx]] = idx;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(n));
        while (!deletes.isEmpty()) {
            int d = deletes.pop();
            sb.setCharAt(d, 'X');
        }
        return sb.toString();
    }
}