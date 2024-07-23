import java.util.*;

class Solution {
    static List<int[]> result;
    public int[][] solution(int n) {
        result = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    public static void hanoi(int n, int start, int to, int end) {
        if (n == 1) {
            result.add(new int[] {start, end});
        } else {
            hanoi(n - 1, start, end, to);
            result.add(new int[] {start, end});
            hanoi(n - 1, to, start, end);
        }
    }
}