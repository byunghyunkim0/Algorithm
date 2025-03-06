import java.util.*;

class Solution {
    static Stack<String> stack;
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, check(s, i));
        }
        return answer;
    }
    
    static int check(String s, int size) {
        stack = new Stack<>();
        stack.add(s.substring(0, size));
        int idx = size;
        int count = 0;
        int len = 0;
        while (idx < s.length()) {
            String temp = s.substring(idx, Math.min(idx + size, s.length()));
            if (stack.peek().equals(temp)) {
                count++;
            } else {
                if (count != 0) {
                    len += String.valueOf(count + 1).length();
                }
                len += size;
                stack.add(temp);
                count = 0;
            }
            idx += size;
        }
        if (count != 0) {
            len += String.valueOf(count + 1).length();
        }
        len += stack.peek().length();
        return len;
    }
}