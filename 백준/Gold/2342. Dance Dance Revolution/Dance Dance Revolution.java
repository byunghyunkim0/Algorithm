import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DanceDance Revolution
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] power = new int[5][5];
        int init = Integer.parseInt(st.nextToken());
        if (init == 0) {
            System.out.println(0);
            return;
        }
        power[init][0] = 2;
        while (true) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                break;
            }
            int[][] temp = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (power[i][j] == 0) {
                        continue;
                    }
                    if (temp[i][num] == 0) {
                        temp[i][num] = power[i][j] + getPower(j, num);
                    } else {
                        temp[i][num] = Math.min(temp[i][num], power[i][j] + getPower(j, num));
                    }
                    if (temp[num][j] == 0) {
                        temp[num][j] = power[i][j] + getPower(i, num);
                    } else {
                        temp[num][j] = Math.min(temp[num][j], power[i][j] + getPower(i, num));
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                System.arraycopy(temp[i], 0, power[i], 0, 5);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (power[i][j] != 0) {
                    result = Math.min(result, power[i][j]);
                }
            }
        }
        System.out.println(result);
    }

    static int getPower(int cur, int next) {
        if (cur == 0) {
            return 2;
        }
        if (cur == next) {
            return 1;
        }
        if (Math.abs(next - cur) == 2) {
            return 4;
        }
        return 3;
    }
}