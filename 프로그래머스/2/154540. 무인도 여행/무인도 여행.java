import java.util.*;

class Solution {
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        visited = new boolean[map.length][map[0].length];
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] > '0' && map[i][j] <= '9') {
                    result.add(bfs(i, j));
                }
            }
        }
        if (result.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.remove();
        }
        return answer;
    }
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int sum = map[x][y] - '0';
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] > '0' && map[nx][ny] <= '9' && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    sum += map[nx][ny] - '0';
                }
            }
        }
        return sum;
    }
}