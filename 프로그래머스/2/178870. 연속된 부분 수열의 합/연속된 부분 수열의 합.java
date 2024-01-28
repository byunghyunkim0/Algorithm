import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, 1000000};
        int[] sum = new int[sequence.length + 1];
        for (int i = 1; i <= sequence.length; i++){
            sum[i] = sum[i - 1] + sequence[i - 1];
        }
        
        int start = 0;
        int end = 0;
        while (start <= sequence.length && end <= sequence.length){
            if (sum[end] - sum[start] == k){
                if (answer[1] - answer[0] > end - start - 1){
                    answer = new int[] {start, end - 1};
                }
                end++;
            } else if (sum[end] - sum[start] > k){
                start++;
            } else {
                end++;
            }
        }
        return answer;
    }
}