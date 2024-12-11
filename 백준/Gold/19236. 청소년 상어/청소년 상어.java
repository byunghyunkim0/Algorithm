import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 청소년 상어
public class Main {
    static class Fish{
        int x;
        int y;
        int dir;
        boolean live;
        public Fish(int x, int y, int dir, boolean live) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.live = live;
        }
    }
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[4][4];
        Fish[] fishes = new Fish[17];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishes[num] = new Fish(i, j, dir, true);
                map[i][j] = num;
            }
        }
        result = 0;
        dfs(0, 0, 0, fishes, map);
        System.out.println(result);
    }

    static void dfs(int x, int y, int sum, Fish[] fishes, int[][] map) {
        sum += map[x][y];
        int dir = fishes[map[x][y]].dir;
        fishes[map[x][y]].live = false;
        result = Math.max(result, sum);

        move(x, y, fishes, map);

        

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                continue;
            }
            if (!fishes[map[nx][ny]].live) {
                continue;
            }

            Fish[] tempFish = new Fish[17];
            for (int j = 1; j < 17; j++) {
                Fish fish = fishes[j];
                tempFish[j] = new Fish(fish.x, fish.y, fish.dir, fish.live);
            }

            int[][] tempMap = new int[4][4];
            for (int a = 0; a < 4; a++) {
                tempMap[a] = map[a].clone();
            }

            dfs(nx, ny, sum, fishes, map);
            fishes = tempFish;
            map = tempMap;
        }
    }

    static void move(int x, int y, Fish[] fishes, int[][] map) {
        for (int i = 1; i < 17; i++) {
            if (!fishes[i].live) {
                continue;
            }
            for (int d = 0; d < 8; d++) {
                int nx = fishes[i].x + dx[fishes[i].dir];
                int ny = fishes[i].y + dy[fishes[i].dir];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == x && ny == y)) {
                    fishes[i].dir = (fishes[i].dir + 1) % 8;
                    continue;
                }
                swap(i, map[nx][ny], fishes, map);
                break;
            }
        }
    }

    static void swap(int a, int b, Fish[] fishes, int[][] map) {
        int tempX = fishes[a].x;
        int tempY = fishes[a].y;
        fishes[a].x = fishes[b].x;
        fishes[a].y = fishes[b].y;
        fishes[b].x = tempX;
        fishes[b].y = tempY;
        map[fishes[a].x][fishes[a].y] = a;
        map[fishes[b].x][fishes[b].y] = b;
    }
}