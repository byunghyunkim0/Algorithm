import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(reverse(reverse(x) + reverse(y)));
    }

    static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            result *= 10;
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}