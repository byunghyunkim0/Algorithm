import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            int a = sc.nextInt() % 10;
            int b = sc.nextInt();
            b %= 4;
            if (b == 0) {
                b = 4;
            }
            if (a == 0) {
                System.out.println(10);
            } else {
                System.out.println((int) Math.pow(a, b) % 10);
            }
        }
    }
}