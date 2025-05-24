import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] myScore = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        int max = 0;
        int sum = myScore[0] + myScore[1];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < max) {
                if (scores[i][0] == myScore[0] && scores[i][1] == myScore[1]) {
                    return -1;
                }
            } else {
                max = Math.max(max, scores[i][1]);
                if (sum < scores[i][0] + scores[i][1]) {
                    answer++;
                }
            }
        }
        return answer;
    }
}