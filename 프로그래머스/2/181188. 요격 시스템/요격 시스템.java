import java.util.*;

class Solution {
    static class Point {
        int start;
        int end;
        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        for (int[] t : targets) {
            queue.add(new Point(t[0], t[1]));
        }
        
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            while (!queue.isEmpty()) {
                if (cur.end <= queue.peek().start) {
                    break;
                }
                cur.start = Math.max(cur.start, queue.peek().start);
                cur.end = Math.min(cur.end, queue.peek().end);
                queue.remove();
            }
            answer++;
        }
        return answer;
    }
}