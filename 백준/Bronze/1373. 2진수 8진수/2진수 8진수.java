import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String number = sc.next();
        int temp = 0;
        for (int i = 0; i < number.length() % 3; i++) {
            temp *= 2;
            temp += number.charAt(i) - '0';
        }
        if (number.length() % 3 != 0) {
            sb.append(temp);
        }
        for (int i = number.length() % 3; i < number.length(); i += 3) {
            int n = 0;
            for (int j = 0; j < 3; j++) {
                n *= 2;
                n += number.charAt(i + j) - '0';
            }
            sb.append(n);
        }
        System.out.println(sb);
    }
}