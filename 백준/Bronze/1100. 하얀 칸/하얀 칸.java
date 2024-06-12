import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        for (int i = 0; i < 8; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                if (((i + j) & 1) == 0) {
                    if (str.charAt(j) == 'F') {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}