import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if (temp >= 'a' && temp <= 'z'){
                System.out.print((char)(temp - 'a' + 'A'));
            } else {
                System.out.print((char)(temp - 'A' + 'a'));
            }
        }
    }
}
