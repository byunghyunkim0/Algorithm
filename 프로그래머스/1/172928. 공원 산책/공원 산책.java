import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] board = new char[park.length][park[0].length()];
        HashMap<String, int[]> d = new HashMap<>();
        d.put("E", new int[] {0, 1});
        d.put("W", new int[] {0, -1});
        d.put("S", new int[] {1, 0});
        d.put("N", new int[] {-1, 0});
        for (int i = 0; i < park.length; i++) {
            board[i] = park[i].toCharArray();
        }
        int x = -1;
        int y = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        f : for (int i = 0; i < routes.length; i++) {
            String[] data = routes[i].split(" ");
            int nx = x;
            int ny = y;
            for (int j = 0; j < Integer.parseInt(data[1]); j++) {
                nx += d.get(data[0])[0];
                ny += d.get(data[0])[1];
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 'X') {
                    continue f;
                }
            }
            x = nx;
            y = ny;
        }
        int[] answer = new int[] {x, y};
        return answer;
    }
}