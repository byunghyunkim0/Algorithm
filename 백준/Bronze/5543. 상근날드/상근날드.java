import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = 3000;
        int c = 3000;
        for (int i = 0; i < 3; i++) {
            b = Math.min(b, sc.nextInt());
        }
        for (int i = 0; i < 2; i++) {
            c = Math.min(c, sc.nextInt());
        }
        System.out.println(b + c - 50);
    }
}