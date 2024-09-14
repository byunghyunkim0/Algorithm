import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static int r;
    static int c;
    static Point character;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        character = new Point(0, 0);
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    character.x = i;
                    character.y = j;
                    map[i][j] = '.';
                }
            }
        }

        // when
        Queue<Point> walking = new LinkedList<>();
        walking.add(character);
        
        boolean[][] visited = new boolean[r][c];
        visited[character.x][character.y] = true;
        
        int count = 0;
        
        boolean flag = false;
        
        f : while (!walking.isEmpty()) {
            water();
            int len = walking.size();
            for (int i = 0; i < len; i++) {
                Point cur = walking.remove();
                if (map[cur.x][cur.y] == 'D') {
                    flag = true;
                    break f;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
                        walking.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }

        // then
        if (flag) {
            System.out.println(count);
        } else {
            System.out.println("KAKTUS");
        }
    }

    static void water() {
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && map[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            map[nx][ny] = '*';
                        }
                    }
                }
            }
        }
    }
}