import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 굴리기
public class Main {
    static int[][] map;
    static int[] commands;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        commands = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        // when
        dice = new int[] {0, 0, 0, 0, 0, 0};
        StringBuilder sb = new StringBuilder();
        for (int command : commands) {
            int nx = x + dx[command];
            int ny = y + dy[command];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                roll(command);
                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[5];
                } else {
                    dice[5] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                sb.append(dice[0]).append("\n");
                x = nx;
                y = ny;
            }
        }

        // then
        System.out.println(sb);
    }

    static void roll(int direction) {
        int temp = dice[0];
        if (direction == 0) {
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;
        } else if (direction == 1) {
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
        } else if (direction == 2) {
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        } else {
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        }
    }
}