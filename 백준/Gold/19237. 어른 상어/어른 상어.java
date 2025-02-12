import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 어른 상어
public class Main {
    static class Shark {
        int x;
        int y;
        int[][] dir;
        int curD;
        boolean live;
        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.live = true;
        }
    }

    static class Smell {
        int idx;
        int time;
        public Smell(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    static int n;
    static int m;
    static int k;
    static int count;
    static int[][] map;
    static Shark[] sharks;
    static Smell[][] smells;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        smells = new Smell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                smells[i][j] = new Smell(0, 0);
            }
        }

        map = new int[n][n];
        sharks = new Shark[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    continue;
                }
                sharks[map[i][j]] = new Shark(i, j);
                smells[i][j].time = k;
                smells[i][j].idx = map[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int shark = 1; shark <= m; shark++) {
            sharks[shark].curD = Integer.parseInt(st.nextToken());
        }

        for (int shark = 1; shark <= m; shark++) {
            int[][] dir = new int[5][4];
            for (int d = 1; d <= 4; d++) {
                st = new StringTokenizer(br.readLine());
                for (int prior = 0; prior < 4; prior++) {
                    dir[d][prior] = Integer.parseInt(st.nextToken());
                }
            }
            sharks[shark].dir = dir;
        }

        int time = 0;
        count = m;
        while (count != 1 && time <= 1000) {
            Move();
            Update();
            Smell();
            time++;
        }
        if (time == 1001) {
            System.out.println(-1);
            return;
        }
        System.out.println(time);
    }

    static void Move() {
        List<Integer> die = new ArrayList<>();

        for (int i = m; i > 0; i--) {
            Shark cur = sharks[i];
            if (!cur.live) {
                continue;
            }

            int d = getDir(cur, i);

            map[cur.x][cur.y] = 0;
            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];
            if (map[nx][ny] != 0) {
                die.add(map[nx][ny]);
            }
            map[nx][ny] = i;
            cur.x = nx;
            cur.y = ny;
            cur.curD = d;
        }

        count -= die.size();
        for (int idx : die) {
            sharks[idx].live = false;
        }
    }

    static int getDir(Shark shark, int idx) {
        List<Integer> noSmell = new ArrayList<>();
        List<Integer> mySmell = new ArrayList<>();
        for (int d = 1; d <= 4; d++) {
            int nx = shark.x + dx[d];
            int ny = shark.y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (smells[nx][ny].idx == idx) {
                mySmell.add(d);
            } else if (smells[nx][ny].idx == 0) {
                noSmell.add(d);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (noSmell.contains(shark.dir[shark.curD][i])) {
                return shark.dir[shark.curD][i];
            }
        }
        for (int i = 0; i < 4; i++) {
            if (mySmell.contains(shark.dir[shark.curD][i])) {
                return shark.dir[shark.curD][i];
            }
        }
        return -1;
    }

    static void Smell() {
        for (int i = m; i > 0; i--) {
            if (!sharks[i].live) {
                continue;
            }
            smells[sharks[i].x][sharks[i].y].time = k;
            smells[sharks[i].x][sharks[i].y].idx = i;
        }
    }

    static void Update() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (smells[i][j].idx == 0) {
                    continue;
                }
                if (smells[i][j].time == 1) {
                    smells[i][j].idx = 0;
                }
                smells[i][j].time--;
            }
        }
    }
}