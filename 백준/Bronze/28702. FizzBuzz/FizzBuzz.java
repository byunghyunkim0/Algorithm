import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        for (int i = 3; i >= 1; i--) {
            String temp = sc.next();
            if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
                result = Integer.parseInt(temp) + i;
            }
        }
        if (result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }
    }
}