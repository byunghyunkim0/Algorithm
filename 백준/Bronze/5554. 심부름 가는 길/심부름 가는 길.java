import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = 0;
        for (int i = 0; i < 4; i++) {
            time += sc.nextInt();
        }
        System.out.println(time / 60);
        System.out.println(time % 60);
    }
}