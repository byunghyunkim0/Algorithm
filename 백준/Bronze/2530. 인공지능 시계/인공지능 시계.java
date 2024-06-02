import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int h = d / 3600;
        d = d % 3600;
        int m = d / 60;
        int s = d % 60 ;
        if (c + s >= 60) {
            c += s - 60;
            b++;
        } else {
            c += s;
        }
        if (b + m >= 60) {
            b += m - 60;
            a++;
        } else {
            b += m;
        }
        if (a + h >= 24) {
            a += h - 24;
        } else {
            a += h;
        }
        a = a % 24;
        System.out.printf("%s %s %s", a, b, c);
    }
}