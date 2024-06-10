import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        for (int i = 0; i < 5; i++) {
            if (n == sc.nextInt()) {
                result++;
            }
        }
        System.out.println(result);
    }
}