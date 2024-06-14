import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(base(str.charAt(0) - '0'));
        for (int i = 1; i < str.length(); i++) {
            int number = str.charAt(i) - '0';
            String temp = base(number);
            if (temp.length() == 2) {
                temp = "0" + temp;
            } else if (temp.length() == 1) {
                temp = "00" + temp;
            }
            sb.append(temp);
        }
        System.out.println(sb);
    }
    static String base(int n) {
        StringBuilder result = new StringBuilder();
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            result.append(n % 2);
            n = n >> 1;
        }
        return result.reverse().toString();
    }
}