import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long result = 0;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int s = (int)Math.ceil(Math.sqrt(m));
        int e = (int)Math.floor(Math.sqrt(n));
        for (int i = s; i <= e; i++) {
            result += (long) i * i;
        }
        if (s > e) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            System.out.println(s * s);
        }
    }
}