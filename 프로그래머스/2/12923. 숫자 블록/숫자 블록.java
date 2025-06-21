import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        int index = 0;
        for (int i = (int)begin; i <= end; i++) {
            int e = (int)Math.sqrt(i) + 1;
            answer[index] = 1;
            for (int j = 2; j <= e; j++) {
                if (i % j == 0) {
                    if (i / j > 10000000) {
                        answer[index] = Math.max(answer[index], j);
                        continue;
                    }
                    answer[index] = i / j;
                    break;
                }
            }
            index++;
        }
        if (begin == 1) {
            answer[0] = 0;
        }
        return answer;
    }
}