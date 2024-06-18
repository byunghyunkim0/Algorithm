import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = y;
        for (int i = 0; i < x; i++) {
            days += month[i];
        }
        System.out.println(day[days % 7]);
    }
}