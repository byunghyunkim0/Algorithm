import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[11][10];
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i < 11; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < j; k++) {
                    arr[i][j] += arr[i - 1][k];
                }
            }
        }
        int result = -1;
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                result += arr[i][j];
            }
            if (result >= n) {
                print(i, result, n);
                return;
            }
        }
        System.out.println(-1);
    }
    static void print(int len, int count, int target) {
        int[] str = new int[len];
        for (int i = 0; i < len; i++) {
            str[i] = 9 - i;
        }
        while (count != target) {
            if (str[len - 1] == 0) {
                int index = 0;
                for (int i = len - 1; i >= 0; i--) {
                    if (str[i] != len - 1 - i) {
                        index = i;
                        break;
                    }
                }
                str[index]--;
                for (int i = index + 1; i < len; i++) {
                    str[i] = str[i - 1] - 1;
                }
            } else {
                str[len - 1]--;
            }
            count--;
        }

        for (int i = 0; i < len; i++) {
            System.out.print(str[i]);
        }
    }
}