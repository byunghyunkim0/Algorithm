import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] result = sc.next().toCharArray();
        for (int i = 0; i < n - 1; i++) {
            String temp = sc.next();
            for (int j = 0; j < temp.length(); j++) {
                if (result[j] != '?' && result[j] != temp.charAt(j)) {
                    result[j] = '?';
                }
            }
        }
        for (char c : result) {
            System.out.print(c);
        }
    }
}
