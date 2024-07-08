class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][][] map;
    static boolean[][][] visited;
    static boolean flag;
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        map = new char[5][5][5];
        visited = new boolean[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = places[i][j].toCharArray();
            }
        }
        next : for (int room = 0; room < 5; room++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[room][i][j] == 'P') {
                        flag = true;
                        check(room, i, j, 0);
                        if (!flag) {
                            answer[room] = 0;
                            continue next;
                        }
                    }
                }
            }
        }
        return answer;
    }
    static void check(int room, int x, int y, int c) {
        visited[room][x][y] = true;
        if (c > 0 && map[room][x][y] == 'P') {
            flag = false;
        }
        if (c == 2) {
            visited[room][x][y] = false;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[room][nx][ny] && map[room][nx][ny] != 'X') {
                check(room, nx, ny, c + 1);
            }
        }
        visited[room][x][y] = false;
    }
}