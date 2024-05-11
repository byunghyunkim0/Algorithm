import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        n = str.length();
        String result = change(str, 0, 1);
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                String temp = change(str, i, j);
                if (check(result, temp)){
                    result = temp;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean check(String str1, String str2) {
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return true;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    public static String change(String str, int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        for (int i = b; i > a; i--){
            sb.append(str.charAt(i));
        }
        for (int i = n - 1; i > b; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}