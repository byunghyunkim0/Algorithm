import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();
        p += t;
        q += t;
        if (((p / w) & 1) == 1) {
            p = w - p % w;
        } else {
            p %= w;
        }
        if (((q / h) & 1) == 1) {
            q = h - q % h;
        } else {
            q %= h;
        }
        System.out.println(p + " " + q);
    }
}