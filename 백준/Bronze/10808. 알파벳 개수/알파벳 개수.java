import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alpha = new int[26];
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'a']++;
        }
        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }
}