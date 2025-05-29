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
    static boolean[][] map;
    static boolean[][] visited;
    static List<List<Point>> node = new ArrayList<>();
    static int n;
    static int m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        map = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < 26; i++) {
            node.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                node.get(storage[i].charAt(j) - 'A').add(new Point(i, j));
            }
        }
        for (String request : requests) {
            if (request.length() == 2) {
                deleteAll(request.charAt(0));
            } else {
                delete(request.charAt(0));
            }
            update();
        }
        answer = count();
        return answer;
    }
    
    static void update() {
        boolean[][] check = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0 && i != n - 1 && j != 0 && j != m - 1) {
                    continue;
                }
                if (check[i][j] || !visited[i][j]) {
                    continue;
                }
                
                queue.add(new Point(i, j));
                check[i][j] = true;
                map[i][j] = true;
                
                while (!queue.isEmpty()) {
                    Point cur = queue.remove();
                    for (int d = 0; d < 4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || check[nx][ny] || !visited[nx][ny]) {
                            continue;
                        }
                        
                        check[nx][ny] = true;
                        map[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
    
    static int count() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
    
    static void delete(char item) {
        List<Point> nodes = new ArrayList<>();
        for (Point p : node.get(item - 'A')) {
            if (map[p.x][p.y]) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny]) {
                    nodes.add(p);
                    break;
                }
            }
        }
        
        for (Point p : nodes) {
            visited[p.x][p.y] = true;
            map[p.x][p.y] = true;
        }
    }
    
    static void deleteAll(char item) {
        for (Point p : node.get(item - 'A')) {
            visited[p.x][p.y] = true;
        }
    }
}