class Solution {
    static class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int solution(int n, int w, int num) {
        int answer = 0;
        Point cur = getPoint(num, w);
        Point max = getPoint(n, w);
        
        if (max.row % 2 == 0) {
            if (max.col >= cur.col) {
                answer = max.row - cur.row + 1;
            } else {
                answer = max.row - cur.row;
            }
        } else {
            if (max.col > cur.col) {
                answer = max.row - cur.row;
            } else {
                answer = max.row - cur.row + 1;
            }
        }
        return answer;
    }
    
    static Point getPoint(int n, int w) {
        int row = (n - 1) / w;
        int col = 0;
        
        if (row % 2 == 0) {
            col = (n - 1) % w;
        } else {
            col = (w - 1 - (n - 1) % w);
        }
        return new Point(row, col);
    }
}