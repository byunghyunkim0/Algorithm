import java.util.Scanner;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        result = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n];
            combination(0, i);
        }
        System.out.println(result);
    }
    static void combination(int index, int count) {
        if (count == 0) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    temp += arr[i];
                }
            }
            if (temp == s) {
                result++;
            }
            return;
        }

        for (int i = index; i < n; i++) {
            visited[i] = true;
            combination(i + 1, count - 1);
            visited[i] = false;
        }
    }
}