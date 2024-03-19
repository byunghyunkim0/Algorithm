import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int result = 0;
        int base = 1;
        for (int i = num.length() - 1; i >= 0; i--){
            char temp = num.charAt(i);
            if (temp >= 'A'){
                result += base * (temp - 'A' + 10);
            } else {
                result += base * (temp - '0');
            }
            base *= 16;
        }
        System.out.println(result);
    }
}