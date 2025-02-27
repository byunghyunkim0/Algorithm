import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int count = n - 1;
        for (int i = 0; i < n; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int idx = i + 1;
            while (idx < n && name.charAt(idx) == 'A') {
                idx++;
            }
            
            count = Math.min(count, i * 2 + n - idx);
            count = Math.min(count, (n - idx) * 2 + i);
            i += idx - i - 1;
        }
        return answer + count;
    }
}