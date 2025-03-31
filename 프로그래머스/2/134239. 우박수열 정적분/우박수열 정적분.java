import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Double> area = new ArrayList<>();
        double cur = k;
        double next = k;
        double s = 0.0;
        area.add(s);
        while (cur != 1) {
            if (cur % 2 == 1) {
                next = cur * 3 + 1;
            } else {
                next = cur / 2;
            }
            area.add(area.get(area.size() - 1) + Math.min(cur, next) + Math.abs(next - cur) / 2);
            cur = next;
        }
        int size = area.size();
        for (int i = 0; i < ranges.length; i++) {
            int end = size - 1 + ranges[i][1];
            int start = ranges[i][0];
            if (end < 0) {
                answer[i] = -1.0;
                continue;
            }
            if (size - 1 + ranges[i][1] < ranges[i][0]) {
                answer[i] = -1.0;
            } else {
                answer[i] = area.get(end) - area.get(start);
            }
        }
        return answer;
    }
}