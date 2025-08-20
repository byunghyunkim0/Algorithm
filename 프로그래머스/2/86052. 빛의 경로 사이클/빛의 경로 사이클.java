import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer> cycle = new ArrayList<>();
    static int[][][] visited;
    static char[][] map;
    static int n;
    static int m;
    static class Point {
        int x;
        int y;
        int dir;
        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = grid[i].toCharArray();
        }
        
        visited = new int[n][m][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (visited[i][j][d] == -1) {
                        continue;
                    }
                    getCycle(i, j, d);
                }
            }
        }
        cycle.sort(Comparator.comparingInt(o -> o));
        
        int[] answer = new int[cycle.size()];
        for (int i = 0; i < cycle.size(); i++) {
            answer[i] = cycle.get(i);
        }
        return answer;
    }
    
    static void getCycle(int x, int y, int dir) {
        List<Point> trace = new ArrayList<>();
        Point cur = new Point(x, y, dir);
        trace.add(cur);
        visited[cur.x][cur.y][cur.dir] = 1;
        
        while (true) {
            Point next = nextPoint(cur.x, cur.y, cur.dir);
            if (visited[next.x][next.y][next.dir] == -1) {
                break;
            } else if (visited[next.x][next.y][next.dir] > 0) {
                cycle.add(visited[cur.x][cur.y][cur.dir] - visited[next.x][next.y][next.dir] + 1);
                break;
            }
            visited[next.x][next.y][next.dir] = visited[cur.x][cur.y][cur.dir] + 1;
            cur = next;
            trace.add(cur);
        }
        for (Point p : trace) {
            visited[p.x][p.y][p.dir] = -1;
        }
    }
    
    static Point nextPoint(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if (nx < 0) {
            nx = n - 1;
        } else if (nx == n) {
            nx = 0;
        }

        if (ny < 0) {
            ny = m - 1;
        } else if (ny == m) {
            ny = 0;
        }
        
        int nd = dir;
        if (map[nx][ny] == 'L') {
            nd = (dir + 3) % 4;
        } else if (map[nx][ny] == 'R') {
            nd = (dir + 1) % 4;
        }
        return new Point(nx, ny, nd);
    }
}