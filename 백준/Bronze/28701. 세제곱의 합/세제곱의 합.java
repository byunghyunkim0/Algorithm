import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = (n + 1) * n / 2;
        System.out.println(result);
        System.out.println(result * result);
        System.out.println(result * result);
    }
}
