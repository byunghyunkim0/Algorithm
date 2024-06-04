import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int result = 0;
        n = (n / 100) * 100;
        for (int i = 0; i < 100; i++) {
            if (n % f == 0) {
                result = n % 100;
                break;
            }
            n++;
        }
        if (result < 10) {
            System.out.println("0" + result);
        } else {
            System.out.println(result);
        }
    }
}