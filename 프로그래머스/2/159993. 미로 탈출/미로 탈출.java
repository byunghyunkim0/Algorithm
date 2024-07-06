import java.util.*;
class Solution {
    static int[][] visited;
    static char[][] map;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;
        int leverX = -1;
        int leverY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                } else if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }
        visited = new int[n][m];
        int disL = getCount(startX, startY, leverX, leverY);
        if (disL == -1) {
            return -1;
        }
        int disE = getCount(leverX, leverY, endX, endY);
        if (disE == -1) {
            return -1;
        }
        answer = disL + disE;
        return answer;
    }
    static int getCount(int startx, int starty, int endx, int endy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startx, starty});
        visited[startx][starty] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0 && map[nx][ny] != 'X') {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                }
            }
        }
        return visited[endx][endy] - 1;
    }
}