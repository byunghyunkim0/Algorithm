import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] alpha = new int[26];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            alpha[str.charAt(0) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] >= 5) {
                sb.append((char)(i + 'a'));
            }
        }
        if (sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }
    }
}