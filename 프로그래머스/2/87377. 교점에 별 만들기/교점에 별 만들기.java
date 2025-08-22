import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        int n = line.length;
        HashMap<Integer, Set<Integer>> points = new HashMap<>();
        Point max = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Point min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point p = getPoint(line[i], line[j]);
                if (p == null) {
                    continue;
                }
                max.x = Math.max(max.x, p.x);
                max.y = Math.max(max.y, p.y);
                min.x = Math.min(min.x, p.x);
                min.y = Math.min(min.y, p.y);
                points.putIfAbsent(p.y, new HashSet<>());
                points.get(p.y).add(p.x);
            }
        }
        
        int len = Math.abs(max.x - min.x) + 1;
        String[] answer = new String[Math.abs(max.y - min.y) + 1];
        for (int i = max.y; i >= min.y; i--) {
            StringBuilder sb = new StringBuilder();
            if (!points.containsKey(i)) {
                answer[max.y - i] = ".".repeat(len);
                continue;
            }
            for (int j = min.x; j <= max.x; j++) {
                sb.append(".");
            }
            for (int idx : points.get(i)) {
                sb.setCharAt(idx - min.x, '*');
            }
            answer[max.y - i] = sb.toString();
        }
        return answer;
    }
    
    static Point getPoint(int[] line1, int[] line2) {
        if (line1[0] * line2[1] == line1[1] * line2[0]) {
            return null;
        }
        long ax = (long)line1[1] * line2[2] - (long)line1[2] * line2[1];
        long ay = (long)line1[2] * line2[0] - (long)line1[0] * line2[2];
        
        long b = (long)line1[0] * line2[1] - (long)line1[1] * line2[0];
        
        if (ax % b != 0 || ay % b != 0) {
            return null;
        }
        return new Point((int)(ax / b), (int)(ay / b));
    }
}