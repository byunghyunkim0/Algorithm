import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int target = (int)Math.sqrt(y - x);
            int result = 0;
            if (target == Math.sqrt(y - x)) {
                result = 2 * target - 1;
            } else if (y - x <= target * (target + 1)) {
                result = 2 * target;
            } else {
                result = 2 * target + 1;
            }
            System.out.println(result);
        }
    }
}