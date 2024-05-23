import java.util.Scanner;

public class Main {
    static char[][] board;
    static char[][] target;
    static int n;
    static int m;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        target = new char[n][m];
        for (int i = 0; i < n; i++){
            board[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < n; i++){
            target[i] = sc.next().toCharArray();
        }
        result = 0;
        for (int i = 0; i < n - 2; i++){
            for (int j = 0; j < m - 2; j++){
                if (board[i][j] != target[i][j]){
                    result++;
                    change(i, j);
                }
            }
        }
        f :for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] != target[i][j]){
                    result = -1;
                    break f;
                }
            }
        }
        System.out.println(result);
    }

    static void change(int x, int y) {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[x + i][y + j] == '0'){
                    board[x + i][y + j] = '1';
                } else {
                    board[x + i][y + j] = '0';
                }
            }
        }
    }
}