import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        long start = 0;
        long end = 0;
        long result = 0;
        while (end <= n && start <= end) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum == n) {
                result++;
                end++;
                sum += end;
            } else {
                start++;
                sum -= start;
            }
        }
        System.out.println(result);
    }
}
