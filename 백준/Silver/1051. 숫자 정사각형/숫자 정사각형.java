import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        int l = Math.min(n, m);
        for (int len = l; len > 0; len--) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    if (map[i][j] == map[i + len - 1][j + len - 1] && map[i][j] == map[i + len - 1][j] && map[i][j] == map[i][j + len - 1]) {
                        System.out.println(len * len);
                        return;
                    }
                }
            }
        }
    }
}