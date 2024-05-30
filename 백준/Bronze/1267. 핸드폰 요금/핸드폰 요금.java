import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int young = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            young += (number / 30 + 1) * 10;
            min += (number / 60 + 1) * 15;
        }
        if (young > min) {
            System.out.printf("M %s", min);
        } else if (young < min) {
            System.out.printf("Y %s", young);
        } else {
            System.out.printf("Y M %s", young);
        }
    }
}
