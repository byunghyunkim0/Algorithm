import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스도쿠
public class Main {
    static int[][] board;
    static int count;
    static boolean flag;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        count = 0;
        for (int i = 0; i < 9; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = temp[j] - '0';
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }

        sb = new StringBuilder();
        flag = false;
        recursive(0);
        System.out.println(sb);
    }

    static void recursive(int c) {
        if (flag) {
            return;
        }

        if (c == count) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    continue;
                }
                for (int num = 1; num <= 9; num++) {
                    if (check(i, j, num)) {
                        board[i][j] = num;
                        recursive(c + 1);
                        board[i][j] = 0;
                    }
                }
                return;
            }
        }
    }

    static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) {
                return false;
            }
            if (board[x][i] == num) {
                return false;
            }
        }
        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[nx + i][ny + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}