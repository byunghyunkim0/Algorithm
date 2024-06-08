import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 0;
        int man = 0;
        for (int i = 0; i < 4; i++) {
            min += sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            man += sc.nextInt();
        }
        System.out.println(Math.max(min, man));
    }
}